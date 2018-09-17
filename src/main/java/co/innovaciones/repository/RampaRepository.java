package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Rampa;

@Repository
public interface RampaRepository extends JpaRepository<Rampa, Integer> {
	
}