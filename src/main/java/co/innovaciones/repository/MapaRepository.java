package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Mapa;

@Repository
public interface MapaRepository extends JpaRepository<Mapa, Integer> {
	
}