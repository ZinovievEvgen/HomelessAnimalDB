package homahoma.service_impl;

import homahoma.model.Pet;
import homahoma.repository.PetRepository;
import homahoma.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet getPetById(Long id) {
        return null;
    }

    @Override
    public void addPet(Pet pet) {

    }

    @Override
    public List<Pet> getAllPet() {
        return null;
    }

    @Override
    public void deletePetById(Long id) {

    }

    @Override
    public void updatePet(Pet pet) {

    }
}
