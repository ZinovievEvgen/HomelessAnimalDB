package homahoma.service_impl;

import homahoma.model.pets.TypeOfWool;
import homahoma.repository.TypeOfWoolRepository;
import homahoma.service.TypeOfWoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfWoolServiceImpl implements TypeOfWoolService {

    @Autowired
    private final TypeOfWoolRepository typeOfWoolRepository;

    public TypeOfWoolServiceImpl(TypeOfWoolRepository typeOfWoolRepository) {
        this.typeOfWoolRepository = typeOfWoolRepository;
    }

    @Override
    public TypeOfWool getTypeOfWoolById(Long id) throws Exception {
        return typeOfWoolRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addTypeOfWool(TypeOfWool typeOfWool) {
        //заменить логгером
        typeOfWoolRepository.save(typeOfWool);
    }

    @Override
    public List<TypeOfWool> getAllTypeOfWool() {
        return typeOfWoolRepository.findAll();
    }

    @Override
    public void deleteTypeOfWoolById(Long id) {
        try {
            typeOfWoolRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeOfWool(TypeOfWool newTypeOfWool) throws Exception {
        typeOfWoolRepository.findById(newTypeOfWool.getId()).map(typeOfWool -> {
            typeOfWool.setName(newTypeOfWool.getName());
            typeOfWool.setPets(newTypeOfWool.getPets());
            return typeOfWoolRepository.save(newTypeOfWool);
        }).orElseThrow(Exception::new);
    }
}
