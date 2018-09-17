package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Reservaagua;
import co.innovaciones.repository.ReservaaguaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReservaaguaService {

	@Autowired
	private ReservaaguaRepository reservaaguaRepository;

	public List<Reservaagua> findAll() {
		return reservaaguaRepository.findAll();
	}

	public Optional<Reservaagua> findById(Integer id) {
		return reservaaguaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Reservaagua save(Reservaagua entity) {
		return reservaaguaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Reservaagua entity) {
		reservaaguaRepository.delete(entity);
	}

}
	
