package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Carpa;

@Repository
public interface CarpaRepository extends JpaRepository<Carpa, Integer> {
	
}