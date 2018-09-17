package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Entrada;
import co.innovaciones.repository.EntradaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;

	public List<Entrada> findAll() {
		return entradaRepository.findAll();
	}

	public Optional<Entrada> findById(Integer id) {
		return entradaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Entrada save(Entrada entity) {
		return entradaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Entrada entity) {
		entradaRepository.delete(entity);
	}

}
	
