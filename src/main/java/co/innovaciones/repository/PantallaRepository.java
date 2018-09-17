package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Pantalla;

@Repository
public interface PantallaRepository extends JpaRepository<Pantalla, Integer> {
	
}