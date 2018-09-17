package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Seccionestacion;

@Repository
public interface SeccionestacionRepository extends JpaRepository<Seccionestacion, Integer> {
	
}