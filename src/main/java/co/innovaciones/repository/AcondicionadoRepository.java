package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Acondicionado;

@Repository
public interface AcondicionadoRepository extends JpaRepository<Acondicionado, Integer> {
	
}