package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Iluminacion;

@Repository
public interface IluminacionRepository extends JpaRepository<Iluminacion, Integer> {
	
}