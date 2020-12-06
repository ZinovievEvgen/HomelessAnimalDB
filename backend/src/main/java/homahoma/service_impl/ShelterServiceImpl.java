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
    public Shelter getShelterById(Long id) throws Exception {
        return shelterRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void addShelter(Shelter shelter) {
        //заменить логгером
        shelterRepository.save(shelter);
    }

    @Override
    public List<Shelter> getAllShelter() {
        return shelterRepository.findAll();
    }

    @Override
    public void deleteShelterById(Long id) {
        try {
            shelterRepository.deleteById(id);
        } catch (Exception e) {
            //заменить логгером
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateShelter(Shelter newShelter) throws Exception {
        shelterRepository.findById(newShelter.getId()).map(shelter -> {
            shelter.setName(newShelter.getName());
            shelter.setAddress(newShelter.getAddress());
            shelter.setChiefFullName(newShelter.getChiefFullName());
            shelter.setEmail(newShelter.getEmail());
            shelter.setPhone(newShelter.getPhone());
            shelter.setWebsite(newShelter.getWebsite());
            shelter.setPets(newShelter.getPets());
            return shelterRepository.save(newShelter);
        }).orElseThrow(Exception::new);
    }
}
