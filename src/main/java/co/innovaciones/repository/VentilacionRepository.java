package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Ventilacion;

@Repository
public interface VentilacionRepository extends JpaRepository<Ventilacion, Integer> {
	
}