package homahoma.service_impl;

import homahoma.model.pets.TypeOfBreed;
import homahoma.repository.TypeOfBreedRepository;
import homahoma.service.TypeOfBreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfBreedServiceImpl implements TypeOfBreedService {

    @Autowired
    private final TypeOfBreedRepository typeOfBreedRepository;

    public TypeOfBreedServiceImpl(TypeOfBreedRepository typeOfBreedRepository) {
        this.typeOfBreedRepository = typeOfBreedRepository;
    }

    @Override
    public TypeOfBreed getTypeOfBreedById(Long id) {
        return null;
    }

    @Override
    public void addTypeOfBreed(TypeOfBreed typeOfBreed) {

    }

    @Override
    public List<TypeOfBreed> getAllTypeOfBreed() {
        return null;
    }

    @Override
    public void deleteTypeOfBreedById(Long id) {

    }

    @Override
    public void updateTypeOfBreed(TypeOfBreed typeOfBreed) {

    }
}
