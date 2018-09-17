package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Cajeroelec;

@Repository
public interface CajeroelecRepository extends JpaRepository<Cajeroelec, Integer> {
	
}