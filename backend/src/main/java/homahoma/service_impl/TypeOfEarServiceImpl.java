package homahoma.service_impl;

import homahoma.model.pets.TypeOfEar;
import homahoma.repository.TypeOfEarRepository;
import homahoma.service.TypeOfEarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfEarServiceImpl implements TypeOfEarService {

    @Autowired
    private final TypeOfEarRepository typeOfEarRepository;

    public TypeOfEarServiceImpl(TypeOfEarRepository typeOfEarRepository) {
        this.typeOfEarRepository = typeOfEarRepository;
    }

    @Override
    public TypeOfEar getTypeOfEarById(Long id) throws Exception {
        return typeOfEarRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addTypeOfEar(TypeOfEar typeOfEar) {
        //заменить логгером
        typeOfEarRepository.save(typeOfEar);
    }

    @Override
    public List<TypeOfEar> getAllTypeOfEar() {
        return typeOfEarRepository.findAll();
    }

    @Override
    public void deleteTypeOfEarById(Long id) {
        try {
            typeOfEarRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeOfEar(TypeOfEar newTypeOfEar) throws Exception {
        typeOfEarRepository.findById(newTypeOfEar.getId()).map(typeOfEar -> {
            typeOfEar.setName(newTypeOfEar.getName());
            typeOfEar.setPets(newTypeOfEar.getPets());
            return typeOfEarRepository.save(newTypeOfEar);
        }).orElseThrow(Exception::new);
    }
}
