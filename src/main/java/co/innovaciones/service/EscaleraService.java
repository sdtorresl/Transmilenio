package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Escalera;
import co.innovaciones.repository.EscaleraRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EscaleraService {

	@Autowired
	private EscaleraRepository escaleraRepository;

	public List<Escalera> findAll() {
		return escaleraRepository.findAll();
	}

	public Optional<Escalera> findById(Integer id) {
		return escaleraRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Escalera save(Escalera entity) {
		return escaleraRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Escalera entity) {
		escaleraRepository.delete(entity);
	}

}
	
