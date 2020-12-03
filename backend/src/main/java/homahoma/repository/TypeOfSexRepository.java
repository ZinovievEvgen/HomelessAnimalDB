package homahoma.repository;

import homahoma.model.pets.TypeOfSex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfSexRepository extends JpaRepository<TypeOfSex, Long> {
}
