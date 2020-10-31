package ru.jun.al.haz.homeless.animal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.ColorOfPet;

public interface ColorOfPetRepository extends JpaRepository<ColorOfPet, Long> {
}
