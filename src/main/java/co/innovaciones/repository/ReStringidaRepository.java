package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.ReStringida;

@Repository
public interface ReStringidaRepository extends JpaRepository<ReStringida, Integer> {
	
}