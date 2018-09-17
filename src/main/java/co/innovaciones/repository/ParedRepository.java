package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Pared;

@Repository
public interface ParedRepository extends JpaRepository<Pared, Integer> {
	
}