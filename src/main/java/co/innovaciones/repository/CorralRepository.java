package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Corral;

@Repository
public interface CorralRepository extends JpaRepository<Corral, Integer> {
	
}