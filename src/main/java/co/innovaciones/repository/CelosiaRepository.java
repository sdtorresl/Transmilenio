package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Celosia;

@Repository
public interface CelosiaRepository extends JpaRepository<Celosia, Integer> {
	
}