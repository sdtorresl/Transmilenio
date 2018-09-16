package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Entrance;

@Repository
public interface EntranceRepository extends JpaRepository<Entrance, Integer> {
	
}