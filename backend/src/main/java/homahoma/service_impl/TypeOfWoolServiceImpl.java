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
    public TypeOfWool getTypeOfWoolById(Long id) {
        return null;
    }

    @Override
    public void addTypeOfWool(TypeOfWool typeOfWool) {

    }

    @Override
    public List<TypeOfWool> getAllTypeOfWool() {
        return null;
    }

    @Override
    public void deleteTypeOfWoolById(Long id) {

    }

    @Override
    public void updateTypeOfWool(TypeOfWool typeOfWool) {

    }
}
