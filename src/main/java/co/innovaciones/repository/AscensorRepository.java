package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Ascensor;

@Repository
public interface AscensorRepository extends JpaRepository<Ascensor, Integer> {
	
}