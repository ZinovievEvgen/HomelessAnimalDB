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
    public Pet getPetById(Long id) throws Exception {
        return petRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addPet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public List<Pet> getAllPet() {
        return petRepository.findAll();
    }

    @Override
    public void deletePetById(Long id) {
        try {
            petRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updatePet(Pet newPet) throws Exception {
        petRepository.findById(newPet.getId()).map(pet -> {
            pet.setName(newPet.getName());
            pet.setTypeOfBreed(newPet.getTypeOfBreed());
            pet.setTypeOfPet(newPet.getTypeOfPet());
            pet.setTypeOfSex(newPet.getTypeOfSex());
            pet.setTypeOfColor(newPet.getTypeOfColor());
            pet.setTypeOfEar(newPet.getTypeOfEar());
            pet.setTypeOfWool(newPet.getTypeOfWool());
            pet.setTypeOfTail(newPet.getTypeOfTail());
            pet.setPathOfPhoto(newPet.getPathOfPhoto());
            pet.setAge(newPet.getAge());
            pet.setWeight(newPet.getWeight());
            pet.setSign(newPet.getSign());
            pet.setCreateedDate(newPet.getCreateedDate());
            pet.setStatus(newPet.getStatus());
            pet.setPerson(newPet.getPerson());
            pet.setShelter(newPet.getShelter());
            return petRepository.save(pet);
        }).orElseThrow(Exception::new);
    }
}
