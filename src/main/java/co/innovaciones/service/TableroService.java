package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Tablero;
import co.innovaciones.repository.TableroRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TableroService {

	@Autowired
	private TableroRepository tableroRepository;

	public List<Tablero> findAll() {
		return tableroRepository.findAll();
	}

	public Optional<Tablero> findById(Integer id) {
		return tableroRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Tablero save(Tablero entity) {
		return tableroRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Tablero entity) {
		tableroRepository.delete(entity);
	}

}
	
