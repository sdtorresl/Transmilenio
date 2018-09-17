package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Pisomaterial;

@Repository
public interface PisomaterialRepository extends JpaRepository<Pisomaterial, Integer> {
	
}