package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Ventanillavagon;
import co.innovaciones.repository.VentanillavagonRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VentanillavagonService {

	@Autowired
	private VentanillavagonRepository ventanillavagonRepository;

	public List<Ventanillavagon> findAll() {
		return ventanillavagonRepository.findAll();
	}

	public Optional<Ventanillavagon> findById(Integer id) {
		return ventanillavagonRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Ventanillavagon save(Ventanillavagon entity) {
		return ventanillavagonRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Ventanillavagon entity) {
		ventanillavagonRepository.delete(entity);
	}

}
	
