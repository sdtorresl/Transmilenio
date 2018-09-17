package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Rampamaterial;

@Repository
public interface RampamaterialRepository extends JpaRepository<Rampamaterial, Integer> {
	
}