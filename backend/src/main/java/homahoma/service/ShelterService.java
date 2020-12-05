package homahoma.service;


import homahoma.model.Shelter;

import java.util.List;

public interface ShelterService {

    Shelter getShelterById(Long id);

    void addShelter(Shelter shelter);

    List<Shelter> getAllShelter();

    void deleteShelterById(Long id);

    void updateShelter(Shelter shelter);
}
