package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Escotilla;

@Repository
public interface EscotillaRepository extends JpaRepository<Escotilla, Integer> {
	
}