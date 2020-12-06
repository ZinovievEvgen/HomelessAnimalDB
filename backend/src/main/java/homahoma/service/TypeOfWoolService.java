package homahoma.service;

import homahoma.model.pets.TypeOfWool;

import java.util.List;

public interface TypeOfWoolService {

    TypeOfWool getTypeOfWoolById(Long id) throws Exception;

    void addTypeOfWool(TypeOfWool typeOfWool);

    List<TypeOfWool> getAllTypeOfWool();

    void deleteTypeOfWoolById(Long id);

    void updateTypeOfWool(TypeOfWool typeOfWool) throws Exception;
}
