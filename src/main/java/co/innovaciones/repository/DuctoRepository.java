package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Ducto;

@Repository
public interface DuctoRepository extends JpaRepository<Ducto, Integer> {
	
}