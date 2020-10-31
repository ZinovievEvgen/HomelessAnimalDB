package ru.jun.al.haz.homeless.animal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.jun.al.haz.homeless.animal.models.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
