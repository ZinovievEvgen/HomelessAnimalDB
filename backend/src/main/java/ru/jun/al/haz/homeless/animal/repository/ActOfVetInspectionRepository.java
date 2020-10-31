package ru.jun.al.haz.homeless.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.ActOfVetInspection;

public interface ActOfVetInspectionRepository extends JpaRepository<ActOfVetInspection, Long> {
}
