package com.arsen.assembly;

import com.arsen.assembly.stations.*;

/*
* Step builder pattern used here as it made the most logical sense. If we allow a factory to assemble a car in any
* order I am certain the cost machinery would be very expensive. So we want the order to be fixed to mitigate machinery
* costs. Example: Cannot polish the car if there are no panels. Hence my decision for this real world approach.
* */
public class Car {
    private final String paint;
    private final String chassis;
    private final String interior;
    private final boolean isPanelsPolished;

    private Car(CarBuilder carBuilder) {
        this.paint = carBuilder.paint;
        this.chassis = carBuilder.chassis;
        this.interior = carBuilder.interior;
        this.isPanelsPolished = carBuilder.isPanelsPolished;
    }

    public String getPaint() {
        return paint;
    }

    public String getChassis() {
        return chassis;
    }

    public String getInterior() {
        return interior;
    }

    public boolean isPanelsPolished() {
        return isPanelsPolished;
    }

    public static MechanicAssemblyStation builder() {
        return new CarBuilder();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
                .append("Car with chassis ").append(chassis)
                .append(" with interior ").append(interior)
                .append(" with paint color ").append(paint);
        if(isPanelsPolished) {
            result.append(" with panels polished");
        }
        return result.toString();
    }

    private static class CarBuilder implements MechanicAssemblyStation, InteriorAssemblyStation, PaintingStation, QualityAssuranceStation, PolishStation, Build {
        private String paint;
        private String chassis;
        private String interior;
        private boolean isPanelsPolished;

        private static final int ACCEPTABLE_RATING = 8;

        private int paintRating;
        private int chassisRating;
        private int interiorRating;
        private int polishRating;

        @Override
        public InteriorAssemblyStation assembleMechanics(String chassis) {
            this.chassisRating = Utils.randomRating();
            this.chassis = chassis;
            return this;
        }

        @Override
        public Build performQualityAssurance() {
            if(chassis == null || chassisRating > ACCEPTABLE_RATING) {
                System.out.println("Chassis was not assembled appropriately");
                this.assembleMechanics(chassis);
            }
            if(interior == null || interiorRating > ACCEPTABLE_RATING) {
                System.out.println("Interior was not assembled appropriately");
                this.assembleInterior(interior);
            }
            if(paint == null || paintRating > ACCEPTABLE_RATING) {
                System.out.println("Panels were not painted appropriately");
            }
            if(polishRating > ACCEPTABLE_RATING) {
                System.out.println("Panels were not polished appropriately");
                this.polishPanels();
            }
            return this;
        }

        @Override
        public PaintingStation assembleInterior(String interior) {
            // Random rating here just as a demonstration. In real case scenario would have a proper rating system.
            this.interiorRating = Utils.randomRating();
            this.interior = interior;
            return this;
        }

        @Override
        public QualityAssuranceStation paintPanels(String color) {
            this.paintRating = Utils.randomRating();
            this.paint = color;
            return this;
        }

        @Override
        public PolishStation paintPanelsPreparePolish(String color) {
            this.paintRating = Utils.randomRating();
            this.paint = color;
            return this;
        }

        @Override
        public QualityAssuranceStation polishPanels() {
            this.polishRating = Utils.randomRating();
            this.isPanelsPolished = true;
            return this;
        }

        @Override
        public Car build() {
            return new Car(this);
        }
    }
}
