package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Parque;

@Repository
public interface ParqueRepository extends JpaRepository<Parque, Integer> {
	
}