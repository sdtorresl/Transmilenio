package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Estribo;

@Repository
public interface EstriboRepository extends JpaRepository<Estribo, Integer> {
	
}