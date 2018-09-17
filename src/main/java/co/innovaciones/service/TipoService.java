package co.innovaciones.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Tipo;
import co.innovaciones.repository.TipoRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TipoService {

	@Autowired
	private TipoRepository tipoRepository;

	public List<Tipo> findAll() {
		return tipoRepository.findAll();
	}

	public Optional<Tipo> findById(Integer id) {
		return tipoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Tipo save(Tipo entity) {
		return tipoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Tipo entity) {
		tipoRepository.delete(entity);
	}

}
	
