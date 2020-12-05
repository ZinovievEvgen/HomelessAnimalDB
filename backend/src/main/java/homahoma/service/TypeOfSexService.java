package homahoma.service;

import homahoma.model.pets.TypeOfSex;

import java.util.List;

public interface TypeOfSexService {

    TypeOfSex getTypeOfSexById(Long id);

    void addTypeOfSex(TypeOfSex typeOfSex);

    List<TypeOfSex> getAllTypeOfSex();

    void deleteTypeOfSexById(Long id);

    void updateTypeOfSex(TypeOfSex typeOfSex);
}
