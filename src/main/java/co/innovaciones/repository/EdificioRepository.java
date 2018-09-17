package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
	
}