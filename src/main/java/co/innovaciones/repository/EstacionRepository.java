package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Estacion;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion, Integer> {
	
}