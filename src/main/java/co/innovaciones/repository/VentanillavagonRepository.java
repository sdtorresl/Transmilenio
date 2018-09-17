package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Ventanillavagon;

@Repository
public interface VentanillavagonRepository extends JpaRepository<Ventanillavagon, Integer> {
	
}