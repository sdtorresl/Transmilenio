package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Conexion;

@Repository
public interface ConexionRepository extends JpaRepository<Conexion, Integer> {
	
}