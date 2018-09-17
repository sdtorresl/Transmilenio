package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Elevadora;

@Repository
public interface ElevadoraRepository extends JpaRepository<Elevadora, Integer> {
	
}