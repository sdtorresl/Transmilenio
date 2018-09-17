package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Grifo;

@Repository
public interface GrifoRepository extends JpaRepository<Grifo, Integer> {
	
}