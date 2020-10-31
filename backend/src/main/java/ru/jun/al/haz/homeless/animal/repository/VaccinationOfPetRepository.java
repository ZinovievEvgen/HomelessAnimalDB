package ru.jun.al.haz.homeless.animal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.VaccinationOfPet;

public interface VaccinationOfPetRepository extends JpaRepository<VaccinationOfPet, Long> {
}
