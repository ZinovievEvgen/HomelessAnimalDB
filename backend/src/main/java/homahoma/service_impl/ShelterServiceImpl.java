package homahoma.service_impl;

import homahoma.model.Shelter;
import homahoma.repository.ShelterRepository;
import homahoma.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterServiceImpl implements ShelterService {

    @Autowired
    private final ShelterRepository shelterRepository;

    public ShelterServiceImpl(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @Override
    public Shelter getShelterById(Long id) {
        return null;
    }

    @Override
    public void addShelter(Shelter shelter) {

    }

    @Override
    public List<Shelter> getAllShelter() {
        return null;
    }

    @Override
    public void deleteShelterById(Long id) {

    }

    @Override
    public void updateShelter(Shelter shelter) {

    }
}
