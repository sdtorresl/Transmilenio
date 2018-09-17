package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {
	
}