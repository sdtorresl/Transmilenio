package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Transformador;

@Repository
public interface TransformadorRepository extends JpaRepository<Transformador, Integer> {
	
}