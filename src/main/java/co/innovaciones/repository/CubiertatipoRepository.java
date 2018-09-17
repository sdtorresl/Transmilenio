package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Cubiertatipo;

@Repository
public interface CubiertatipoRepository extends JpaRepository<Cubiertatipo, Integer> {
	
}