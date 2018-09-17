package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Recarga;
import co.innovaciones.repository.RecargaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RecargaService {

	@Autowired
	private RecargaRepository recargaRepository;

	public List<Recarga> findAll() {
		return recargaRepository.findAll();
	}

	public Optional<Recarga> findById(Integer id) {
		return recargaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Recarga save(Recarga entity) {
		return recargaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Recarga entity) {
		recargaRepository.delete(entity);
	}

}
	
