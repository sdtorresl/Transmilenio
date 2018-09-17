package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Isquiatico;

@Repository
public interface IsquiaticoRepository extends JpaRepository<Isquiatico, Integer> {
	
}