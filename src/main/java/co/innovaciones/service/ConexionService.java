package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Conexion;
import co.innovaciones.repository.ConexionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ConexionService {

	@Autowired
	private ConexionRepository conexionRepository;

	public List<Conexion> findAll() {
		return conexionRepository.findAll();
	}

	public Optional<Conexion> findById(Integer id) {
		return conexionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Conexion save(Conexion entity) {
		return conexionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Conexion entity) {
		conexionRepository.delete(entity);
	}

}
	
