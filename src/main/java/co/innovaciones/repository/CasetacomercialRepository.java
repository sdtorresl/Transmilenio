package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Casetacomercial;

@Repository
public interface CasetacomercialRepository extends JpaRepository<Casetacomercial, Integer> {
	
}