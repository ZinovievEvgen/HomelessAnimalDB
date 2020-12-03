package homahoma.repository;

import homahoma.model.pets.TypeOfEar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfEarRepository extends JpaRepository<TypeOfEar, Long> {
}
