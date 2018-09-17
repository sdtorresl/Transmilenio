package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Cuarto;
import co.innovaciones.repository.CuartoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CuartoService {

	@Autowired
	private CuartoRepository cuartoRepository;

	public List<Cuarto> findAll() {
		return cuartoRepository.findAll();
	}

	public Optional<Cuarto> findById(Integer id) {
		return cuartoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Cuarto save(Cuarto entity) {
		return cuartoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Cuarto entity) {
		cuartoRepository.delete(entity);
	}

}
	
