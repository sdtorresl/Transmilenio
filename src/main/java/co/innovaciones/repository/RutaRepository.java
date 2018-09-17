package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Integer> {
	
}