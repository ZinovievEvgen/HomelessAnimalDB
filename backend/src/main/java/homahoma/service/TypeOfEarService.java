package homahoma.service;


import homahoma.model.pets.TypeOfEar;

import java.util.List;

public interface TypeOfEarService {

    TypeOfEar getTypeOfEarById(Long id) throws Exception;

    void addTypeOfEar(TypeOfEar typeOfEar);

    List<TypeOfEar> getAllTypeOfEar();

    void deleteTypeOfEarById(Long id);

    void updateTypeOfEar(TypeOfEar typeOfEar) throws Exception;
}
