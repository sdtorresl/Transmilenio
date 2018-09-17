package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Canal;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Integer> {
	
}