package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Puertatroncal;

@Repository
public interface PuertatroncalRepository extends JpaRepository<Puertatroncal, Integer> {
	
}