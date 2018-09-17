package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Canecas;

@Repository
public interface CanecasRepository extends JpaRepository<Canecas, Integer> {
	
}