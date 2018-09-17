package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Publicidad;

@Repository
public interface PublicidadRepository extends JpaRepository<Publicidad, Integer> {
	
}