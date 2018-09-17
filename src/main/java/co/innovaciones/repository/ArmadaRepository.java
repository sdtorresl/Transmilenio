package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Armada;

@Repository
public interface ArmadaRepository extends JpaRepository<Armada, Integer> {
	
}