package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Escalera;

@Repository
public interface EscaleraRepository extends JpaRepository<Escalera, Integer> {
	
}