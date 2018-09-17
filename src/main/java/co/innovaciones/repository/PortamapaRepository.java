package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Portamapa;

@Repository
public interface PortamapaRepository extends JpaRepository<Portamapa, Integer> {
	
}