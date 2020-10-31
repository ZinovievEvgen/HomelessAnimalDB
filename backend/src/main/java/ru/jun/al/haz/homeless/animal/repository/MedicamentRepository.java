package ru.jun.al.haz.homeless.animal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.Medicament;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}
