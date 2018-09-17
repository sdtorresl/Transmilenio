package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Informador;

@Repository
public interface InformadorRepository extends JpaRepository<Informador, Integer> {
	
}