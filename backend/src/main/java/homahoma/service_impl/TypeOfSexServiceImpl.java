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
    public TypeOfSex getTypeOfSexById(Long id) {
        return null;
    }

    @Override
    public void addTypeOfSex(TypeOfSex typeOfSex) {

    }

    @Override
    public List<TypeOfSex> getAllTypeOfSex() {
        return null;
    }

    @Override
    public void deleteTypeOfSexById(Long id) {

    }

    @Override
    public void updateTypeOfSex(TypeOfSex typeOfSex) {

    }
}
