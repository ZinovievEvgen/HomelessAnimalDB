package homahoma.service_impl;

import homahoma.model.pets.TypeOfPet;
import homahoma.repository.TypeOfPetRepository;
import homahoma.service.TypeOfPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfPetServiceImpl implements TypeOfPetService {

    @Autowired
    private final TypeOfPetRepository typeOfPetRepository;

    public TypeOfPetServiceImpl(TypeOfPetRepository typeOfPetRepository) {
        this.typeOfPetRepository = typeOfPetRepository;
    }

    @Override
    public TypeOfPet getTypeOfPetById(Long id) {
        return null;
    }

    @Override
    public void addTypeOfPet(TypeOfPet typeOfPet) {

    }

    @Override
    public List<TypeOfPet> getAllTypeOfPet() {
        return null;
    }

    @Override
    public void deleteTypeOfPetById(Long id) {

    }

    @Override
    public void updateTypeOfPet(TypeOfPet typeOfPet) {

    }
}
