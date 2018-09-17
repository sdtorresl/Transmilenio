package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Toma;

@Repository
public interface TomaRepository extends JpaRepository<Toma, Integer> {
	
}