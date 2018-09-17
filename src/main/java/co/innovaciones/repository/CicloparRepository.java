package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Ciclopar;

@Repository
public interface CicloparRepository extends JpaRepository<Ciclopar, Integer> {
	
}