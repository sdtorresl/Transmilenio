package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Toteminfor;

@Repository
public interface ToteminforRepository extends JpaRepository<Toteminfor, Integer> {
	
}