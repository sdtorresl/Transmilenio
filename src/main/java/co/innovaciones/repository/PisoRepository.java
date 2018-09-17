package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Piso;

@Repository
public interface PisoRepository extends JpaRepository<Piso, Integer> {
	
}