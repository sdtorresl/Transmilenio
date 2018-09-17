package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Cubierta;

@Repository
public interface CubiertaRepository extends JpaRepository<Cubierta, Integer> {
	
}