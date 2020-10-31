package ru.jun.al.haz.homeless.animal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.TypeOfEarPet;

public interface TypeOfEarPetRepository extends JpaRepository<TypeOfEarPet, Long> {
}
