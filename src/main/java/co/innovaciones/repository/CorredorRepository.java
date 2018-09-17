package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Corredor;

@Repository
public interface CorredorRepository extends JpaRepository<Corredor, Integer> {
	
}