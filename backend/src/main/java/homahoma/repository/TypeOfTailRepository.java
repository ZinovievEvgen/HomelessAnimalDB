package homahoma.repository;

import homahoma.model.pets.TypeOfTail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfTailRepository extends JpaRepository<TypeOfTail, Long> {
}
