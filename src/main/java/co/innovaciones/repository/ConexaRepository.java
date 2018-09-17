package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Conexa;

@Repository
public interface ConexaRepository extends JpaRepository<Conexa, Integer> {
	
}