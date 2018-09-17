package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Lectortarjeta;
import co.innovaciones.repository.LectortarjetaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LectortarjetaService {

	@Autowired
	private LectortarjetaRepository lectortarjetaRepository;

	public List<Lectortarjeta> findAll() {
		return lectortarjetaRepository.findAll();
	}

	public Optional<Lectortarjeta> findById(Integer id) {
		return lectortarjetaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Lectortarjeta save(Lectortarjeta entity) {
		return lectortarjetaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Lectortarjeta entity) {
		lectortarjetaRepository.delete(entity);
	}

}
	
