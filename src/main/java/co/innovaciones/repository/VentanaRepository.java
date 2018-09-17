package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Ventana;

@Repository
public interface VentanaRepository extends JpaRepository<Ventana, Integer> {
	
}