package ru.jun.al.haz.homeless.animal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.TypeOfPet;

public interface TypeOfPetRepository extends JpaRepository<TypeOfPet, Long> {
}
