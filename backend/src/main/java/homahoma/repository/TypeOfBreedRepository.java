package homahoma.repository;

import homahoma.model.pets.TypeOfBreed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfBreedRepository extends JpaRepository<TypeOfBreed, Long> {
}
