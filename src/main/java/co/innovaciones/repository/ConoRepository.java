package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Cono;

@Repository
public interface ConoRepository extends JpaRepository<Cono, Integer> {
	
}