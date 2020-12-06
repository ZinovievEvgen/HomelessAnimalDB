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
    public TypeOfBreed getTypeOfBreedById(Long id) throws Exception {
        return typeOfBreedRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addTypeOfBreed(TypeOfBreed typeOfBreed) {
        //заменить логгером
        typeOfBreedRepository.save(typeOfBreed);
    }

    @Override
    public List<TypeOfBreed> getAllTypeOfBreed() {
        return typeOfBreedRepository.findAll();
    }

    @Override
    public void deleteTypeOfBreedById(Long id) {
        try {
            typeOfBreedRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeOfBreed(TypeOfBreed newTypeOfBreed) throws Exception {
        typeOfBreedRepository.findById(newTypeOfBreed.getId()).map(typeOfBreed -> {
            typeOfBreed.setName(newTypeOfBreed.getName());
            typeOfBreed.setPets(newTypeOfBreed.getPets());
            typeOfBreed.setTypeOfPet(newTypeOfBreed.getTypeOfPet());
            return typeOfBreedRepository.save(newTypeOfBreed);
        }).orElseThrow(Exception::new);
    }
}
