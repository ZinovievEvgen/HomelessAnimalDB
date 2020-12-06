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
    public TypeOfTail getTypeOfTailById(Long id) throws Exception {
        return typeOfTailRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addTypeOfTail(TypeOfTail typeOfTail) {
        //заменить логгером
        typeOfTailRepository.save(typeOfTail);

    }

    @Override
    public List<TypeOfTail> getAllTypeOfTail() {
        return typeOfTailRepository.findAll();
    }

    @Override
    public void deleteTypeOfTailById(Long id) {
        try {
            typeOfTailRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeOfTail(TypeOfTail newTypeOfTail) throws Exception {
        typeOfTailRepository.findById(newTypeOfTail.getId()).map(typeOfTail -> {
            typeOfTail.setName(newTypeOfTail.getName());
            typeOfTail.setPets(newTypeOfTail.getPets());
            return typeOfTailRepository.save(newTypeOfTail);
        }).orElseThrow(Exception::new);
    }
}
