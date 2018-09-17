package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Noopera;

@Repository
public interface NooperaRepository extends JpaRepository<Noopera, Integer> {
	
}