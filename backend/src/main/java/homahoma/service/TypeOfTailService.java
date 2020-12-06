package homahoma.service;


import homahoma.model.pets.TypeOfTail;

import java.util.List;

public interface TypeOfTailService {

    TypeOfTail getTypeOfTailById(Long id) throws Exception;

    void addTypeOfTail(TypeOfTail typeOfTail);

    List<TypeOfTail> getAllTypeOfTail();

    void deleteTypeOfTailById(Long id);

    void updateTypeOfTail(TypeOfTail typeOfTail) throws Exception;
}
