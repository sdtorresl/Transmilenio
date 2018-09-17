package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Tanquecombustible;

@Repository
public interface TanquecombustibleRepository extends JpaRepository<Tanquecombustible, Integer> {
	
}