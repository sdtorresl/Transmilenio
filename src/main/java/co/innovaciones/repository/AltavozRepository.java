package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Altavoz;

@Repository
public interface AltavozRepository extends JpaRepository<Altavoz, Integer> {
	
}