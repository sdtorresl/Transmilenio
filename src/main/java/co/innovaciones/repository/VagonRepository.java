package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Vagon;

@Repository
public interface VagonRepository extends JpaRepository<Vagon, Integer> {
	
}