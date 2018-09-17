package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Biblioestacion;
import co.innovaciones.repository.BiblioestacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BiblioestacionService {

	@Autowired
	private BiblioestacionRepository biblioestacionRepository;

	public List<Biblioestacion> findAll() {
		return biblioestacionRepository.findAll();
	}

	public Optional<Biblioestacion> findById(Integer id) {
		return biblioestacionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Biblioestacion save(Biblioestacion entity) {
		return biblioestacionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Biblioestacion entity) {
		biblioestacionRepository.delete(entity);
	}

}
	
