package homahoma.service;


import homahoma.model.pets.TypeOfColor;

import java.util.List;

public interface TypeOfColorService {

    TypeOfColor getTypeOfColorById(Long id);

    void addTypeOfColor(TypeOfColor typeOfColor);

    List<TypeOfColor> getAllTypeOfColor();

    void deleteTypeOfColorById(Long id);

    void updateTypeOfColor(TypeOfColor typeOfColor);
}
