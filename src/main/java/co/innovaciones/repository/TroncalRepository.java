package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Troncal;

@Repository
public interface TroncalRepository extends JpaRepository<Troncal, Integer> {
	
}