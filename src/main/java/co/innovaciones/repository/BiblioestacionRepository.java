package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Biblioestacion;

@Repository
public interface BiblioestacionRepository extends JpaRepository<Biblioestacion, Integer> {
	
}