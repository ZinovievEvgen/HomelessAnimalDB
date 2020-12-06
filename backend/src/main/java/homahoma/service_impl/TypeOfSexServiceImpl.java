package homahoma.service_impl;

import homahoma.model.pets.TypeOfSex;
import homahoma.repository.TypeOfSexRepository;
import homahoma.service.TypeOfSexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfSexServiceImpl implements TypeOfSexService {

    @Autowired
    private final TypeOfSexRepository typeOfSexRepository;

    public TypeOfSexServiceImpl(TypeOfSexRepository typeOfSexRepository) {
        this.typeOfSexRepository = typeOfSexRepository;
    }

    @Override
    public TypeOfSex getTypeOfSexById(Long id) throws Exception {
        return typeOfSexRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addTypeOfSex(TypeOfSex typeOfSex) {
        //заменить логгером
        typeOfSexRepository.save(typeOfSex);
    }

    @Override
    public List<TypeOfSex> getAllTypeOfSex() {
        return typeOfSexRepository.findAll();
    }

    @Override
    public void deleteTypeOfSexById(Long id) {
        try {
            typeOfSexRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeOfSex(TypeOfSex newTypeOfSex) throws Exception {
        typeOfSexRepository.findById(newTypeOfSex.getId()).map(typeOfSex -> {
            typeOfSex.setName(newTypeOfSex.getName());
            typeOfSex.setPets(newTypeOfSex.getPets());
            return typeOfSexRepository.save(newTypeOfSex);
        }).orElseThrow(Exception::new);
    }
}
