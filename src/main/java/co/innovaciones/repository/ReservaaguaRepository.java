package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Reservaagua;

@Repository
public interface ReservaaguaRepository extends JpaRepository<Reservaagua, Integer> {
	
}