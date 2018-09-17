package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Evacuacion;

@Repository
public interface EvacuacionRepository extends JpaRepository<Evacuacion, Integer> {
	
}