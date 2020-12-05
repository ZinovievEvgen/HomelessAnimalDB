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
    public TypeOfEar getTypeOfEarById(Long id) {
        return null;
    }

    @Override
    public void addTypeOfEar(TypeOfEar typeOfEar) {

    }

    @Override
    public List<TypeOfEar> getAllTypeOfEar() {
        return null;
    }

    @Override
    public void deleteTypeOfEarById(Long id) {

    }

    @Override
    public void updateTypeOfEar(TypeOfEar typeOfEar) {

    }
}
