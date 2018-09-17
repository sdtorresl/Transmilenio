package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Lectortarjeta;

@Repository
public interface LectortarjetaRepository extends JpaRepository<Lectortarjeta, Integer> {
	
}