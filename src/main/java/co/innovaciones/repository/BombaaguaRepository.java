package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Bombaagua;

@Repository
public interface BombaaguaRepository extends JpaRepository<Bombaagua, Integer> {
	
}