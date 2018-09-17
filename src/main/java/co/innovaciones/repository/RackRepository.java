package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Rack;

@Repository
public interface RackRepository extends JpaRepository<Rack, Integer> {
	
}