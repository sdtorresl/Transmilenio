package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Silla;

@Repository
public interface SillaRepository extends JpaRepository<Silla, Integer> {
	
}