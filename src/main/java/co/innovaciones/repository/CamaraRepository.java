package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Camara;

@Repository
public interface CamaraRepository extends JpaRepository<Camara, Integer> {
	
}