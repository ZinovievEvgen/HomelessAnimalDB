package homahoma.model;

import homahoma.model.pets.TypeOfBreed;
import homahoma.model.pets.TypeOfColor;
import homahoma.model.pets.TypeOfEar;
import homahoma.model.pets.TypeOfPet;

import java.time.LocalDateTime;

/**
 * Created by SaidHazzarD on 04.12.2020.
 */
public class TextDataRequest {

    private Long id;
    private TypeOfBreed typeOfBreed;
    private TypeOfPet typeOfPet;
    private TypeOfEar typeOfEar;
    private TypeOfColor typeOfColor;

    //user

    private LocalDateTime createedDate;

    public void requestToMMO(){

    }

    public void responseFromMMO(){

    }

}
