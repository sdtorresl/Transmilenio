package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Barreraper;

@Repository
public interface BarreraperRepository extends JpaRepository<Barreraper, Integer> {
	
}