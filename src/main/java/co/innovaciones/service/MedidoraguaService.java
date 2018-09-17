package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Medidoragua;
import co.innovaciones.repository.MedidoraguaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MedidoraguaService {

	@Autowired
	private MedidoraguaRepository medidoraguaRepository;

	public List<Medidoragua> findAll() {
		return medidoraguaRepository.findAll();
	}

	public Optional<Medidoragua> findById(Integer id) {
		return medidoraguaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Medidoragua save(Medidoragua entity) {
		return medidoraguaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Medidoragua entity) {
		medidoraguaRepository.delete(entity);
	}

}
	
