package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Celosiaestribo;

@Repository
public interface CelosiaestriboRepository extends JpaRepository<Celosiaestribo, Integer> {
	
}