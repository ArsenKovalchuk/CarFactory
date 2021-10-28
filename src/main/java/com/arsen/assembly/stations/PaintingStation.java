package com.arsen.assembly.stations;

public interface PaintingStation {
    QualityAssuranceStation paintPanels(String color);

    // Added as optional station
    PolishStation paintPanelsPreparePolish(String color);
}
