package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Columna;
import co.innovaciones.repository.ColumnaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ColumnaService {

	@Autowired
	private ColumnaRepository columnaRepository;

	public List<Columna> findAll() {
		return columnaRepository.findAll();
	}

	public Optional<Columna> findById(Integer id) {
		return columnaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Columna save(Columna entity) {
		return columnaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Columna entity) {
		columnaRepository.delete(entity);
	}

}
	
