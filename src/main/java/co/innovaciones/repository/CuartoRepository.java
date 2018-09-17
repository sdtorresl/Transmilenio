package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Cuarto;

@Repository
public interface CuartoRepository extends JpaRepository<Cuarto, Integer> {
	
}