package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Caniles;

@Repository
public interface CanilesRepository extends JpaRepository<Caniles, Integer> {
	
}