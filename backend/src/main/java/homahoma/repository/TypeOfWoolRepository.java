package homahoma.repository;

import homahoma.model.pets.TypeOfWool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfWoolRepository extends JpaRepository<TypeOfWool, Long> {
}
