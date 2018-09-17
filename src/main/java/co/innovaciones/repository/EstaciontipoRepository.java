package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Estaciontipo;

@Repository
public interface EstaciontipoRepository extends JpaRepository<Estaciontipo, Integer> {
	
}