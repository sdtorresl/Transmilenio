package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Incendio;

@Repository
public interface IncendioRepository extends JpaRepository<Incendio, Integer> {
	
}