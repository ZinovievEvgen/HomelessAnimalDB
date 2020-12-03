package homahoma.repository;

import homahoma.model.pets.TypeOfColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfColorRepository extends JpaRepository<TypeOfColor, Long> {
}
