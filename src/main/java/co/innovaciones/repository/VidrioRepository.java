package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Vidrio;

@Repository
public interface VidrioRepository extends JpaRepository<Vidrio, Integer> {
	
}