package homahoma.repository;

import homahoma.model.pets.TypeOfPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfPetRepository extends JpaRepository<TypeOfPet, Long> {
}
