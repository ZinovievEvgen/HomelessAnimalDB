package homahoma.service;


import homahoma.model.Pet;

import java.util.List;

public interface PetService {

    Pet getPetById(Long id);

    void addPet(Pet pet);

    List<Pet> getAllPet();

    void deletePetById(Long id);

    void updatePet(Pet pet);

}
