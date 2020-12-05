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
    public TypeOfColor getTypeOfColorById(Long id) {
        return null;
    }

    @Override
    public void addTypeOfColor(TypeOfColor typeOfColor) {

    }

    @Override
    public List<TypeOfColor> getAllTypeOfColor() {
        return null;
    }

    @Override
    public void deleteTypeOfColorById(Long id) {

    }

    @Override
    public void updateTypeOfColor(TypeOfColor typeOfColor) {

    }
}
