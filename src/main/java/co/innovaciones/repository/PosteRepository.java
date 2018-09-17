package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Poste;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Integer> {
	
}