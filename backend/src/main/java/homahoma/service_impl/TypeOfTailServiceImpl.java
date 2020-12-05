package homahoma.service_impl;

import homahoma.model.pets.TypeOfTail;
import homahoma.repository.TypeOfTailRepository;
import homahoma.service.TypeOfTailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfTailServiceImpl implements TypeOfTailService {

    @Autowired
    private final TypeOfTailRepository typeOfTailRepository;

    public TypeOfTailServiceImpl(TypeOfTailRepository typeOfTailRepository) {
        this.typeOfTailRepository = typeOfTailRepository;
    }

    @Override
    public TypeOfTail getTypeOfTailById(Long id) {
        return null;
    }

    @Override
    public void addTypeOfTail(TypeOfTail typeOfTail) {

    }

    @Override
    public List<TypeOfTail> getAllTypeOfTail() {
        return null;
    }

    @Override
    public void deleteTypeOfTailById(Long id) {

    }

    @Override
    public void updateTypeOfTail(TypeOfTail typeOfTail) {

    }
}
