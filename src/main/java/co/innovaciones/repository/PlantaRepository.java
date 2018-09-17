package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Planta;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Integer> {
	
}