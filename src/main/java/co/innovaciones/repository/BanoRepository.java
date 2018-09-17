package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Bano;

@Repository
public interface BanoRepository extends JpaRepository<Bano, Integer> {
	
}