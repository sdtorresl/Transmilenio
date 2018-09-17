package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Conexa;
import co.innovaciones.repository.ConexaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ConexaService {

	@Autowired
	private ConexaRepository conexaRepository;

	public List<Conexa> findAll() {
		return conexaRepository.findAll();
	}

	public Optional<Conexa> findById(Integer id) {
		return conexaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Conexa save(Conexa entity) {
		return conexaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Conexa entity) {
		conexaRepository.delete(entity);
	}

}
	
