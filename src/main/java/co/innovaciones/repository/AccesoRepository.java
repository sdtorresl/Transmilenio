package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Acceso;

@Repository
public interface AccesoRepository extends JpaRepository<Acceso, Integer> {
	
}