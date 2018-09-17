package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
}