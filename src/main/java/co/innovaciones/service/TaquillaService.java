package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Taquilla;
import co.innovaciones.repository.TaquillaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TaquillaService {

	@Autowired
	private TaquillaRepository taquillaRepository;

	public List<Taquilla> findAll() {
		return taquillaRepository.findAll();
	}

	public Optional<Taquilla> findById(Integer id) {
		return taquillaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Taquilla save(Taquilla entity) {
		return taquillaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Taquilla entity) {
		taquillaRepository.delete(entity);
	}

}
	
