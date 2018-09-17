package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Primerauxilio;

@Repository
public interface PrimerauxilioRepository extends JpaRepository<Primerauxilio, Integer> {
	
}