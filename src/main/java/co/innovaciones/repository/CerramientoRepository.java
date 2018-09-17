package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Cerramiento;

@Repository
public interface CerramientoRepository extends JpaRepository<Cerramiento, Integer> {
	
}