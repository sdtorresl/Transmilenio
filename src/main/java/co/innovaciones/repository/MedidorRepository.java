package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Medidor;

@Repository
public interface MedidorRepository extends JpaRepository<Medidor, Integer> {
	
}