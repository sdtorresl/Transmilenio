package co.innovaciones.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.innovaciones.model.Barandaentrada;

@Repository
public interface BarandaentradaRepository extends JpaRepository<Barandaentrada, Integer> {
	
}