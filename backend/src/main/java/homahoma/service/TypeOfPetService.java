package homahoma.service;


import homahoma.model.pets.TypeOfPet;

import java.util.List;

public interface TypeOfPetService {

    TypeOfPet getTypeOfPetById(Long id) throws Exception;

    void addTypeOfPet(TypeOfPet typeOfPet);

    List<TypeOfPet> getAllTypeOfPet();

    void deleteTypeOfPetById(Long id);

    void updateTypeOfPet(TypeOfPet typeOfPet) throws Exception;
}
