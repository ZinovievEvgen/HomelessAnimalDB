package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

/**
 * Слой сущностей БД (Model)
 * класс-Форма данных для поиска юзером (запрос/ответ): содержит форму запроса пользователем
 * информации из БД и форму ответа по результатам поиска
 */
@Data
public class FormBySearchDataOfUser {

    //размер
    private String sizeOfPet;

    //ОКРАС
    private String nameOfColorPet;

    //ШЕРСТЬ
    private String nameOfTypeWoolPet;

    //УШИ
    private String nameOfTypeEarPet;

    //ХВОСТ
    private String nameOfTypeOfTailPet;

    public FormBySearchDataOfUser() {
    }
}
