package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Puerta;

@Repository
public interface PuertaRepository extends JpaRepository<Puerta, Integer> {
	
}