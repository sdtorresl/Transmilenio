package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Derivacion;

@Repository
public interface DerivacionRepository extends JpaRepository<Derivacion, Integer> {
	
}