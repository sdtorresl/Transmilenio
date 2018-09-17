package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Gamin;

@Repository
public interface GaminRepository extends JpaRepository<Gamin, Integer> {
	
}