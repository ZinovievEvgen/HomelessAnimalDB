package homahoma.service;


import homahoma.model.pets.TypeOfBreed;

import java.util.List;

public interface TypeOfBreedService {

    TypeOfBreed getTypeOfBreedById(Long id) throws Exception;

    void addTypeOfBreed(TypeOfBreed typeOfBreed);

    List<TypeOfBreed> getAllTypeOfBreed();

    void deleteTypeOfBreedById(Long id);

    void updateTypeOfBreed(TypeOfBreed typeOfBreed) throws Exception;
}
