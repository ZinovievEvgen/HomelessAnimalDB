package homahoma.service_impl;

import homahoma.model.pets.TypeOfColor;
import homahoma.repository.TypeOfColorRepository;
import homahoma.service.TypeOfColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfColorServiceImpl implements TypeOfColorService {

    @Autowired
    private final TypeOfColorRepository typeOfColorRepository;

    public TypeOfColorServiceImpl(TypeOfColorRepository typeOfColorRepository) {
        this.typeOfColorRepository = typeOfColorRepository;
    }

    @Override
    public TypeOfColor getTypeOfColorById(Long id) throws Exception {
        return typeOfColorRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addTypeOfColor(TypeOfColor typeOfColor) {
        //заменить логгером
        typeOfColorRepository.save(typeOfColor);
    }

    @Override
    public List<TypeOfColor> getAllTypeOfColor() {
        return typeOfColorRepository.findAll();
    }

    @Override
    public void deleteTypeOfColorById(Long id) {
        try {
            typeOfColorRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateTypeOfColor(TypeOfColor newTypeOfColor) throws Exception {
        typeOfColorRepository.findById(newTypeOfColor.getId()).map(typeOfBreed -> {
            typeOfBreed.setName(newTypeOfColor.getName());
            typeOfBreed.setPets(newTypeOfColor.getPets());
            return typeOfColorRepository.save(newTypeOfColor);
        }).orElseThrow(Exception::new);
    }
}
