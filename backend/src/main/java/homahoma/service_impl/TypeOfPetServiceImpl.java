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
    public TypeOfPet getTypeOfPetById(Long id) throws Exception {
        return typeOfPetRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addTypeOfPet(TypeOfPet typeOfPet) {
        //заменить логгером
        typeOfPetRepository.save(typeOfPet);
    }

    @Override
    public List<TypeOfPet> getAllTypeOfPet() {
        return typeOfPetRepository.findAll();
    }

    @Override
    public void deleteTypeOfPetById(Long id) {
        try {
            typeOfPetRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeOfPet(TypeOfPet newTypeOfPet) throws Exception {
        typeOfPetRepository.findById(newTypeOfPet.getId()).map(typeOfPet -> {
            typeOfPet.setName(newTypeOfPet.getName());
            typeOfPet.setPets(newTypeOfPet.getPets());
            typeOfPet.setTypeOfBreedList(newTypeOfPet.getTypeOfBreedList());
            return typeOfPetRepository.save(newTypeOfPet);
        }).orElseThrow(Exception::new);
    }
}
