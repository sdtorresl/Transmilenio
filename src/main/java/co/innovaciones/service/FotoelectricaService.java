package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Fotoelectrica;
import co.innovaciones.repository.FotoelectricaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class FotoelectricaService {

	@Autowired
	private FotoelectricaRepository fotoelectricaRepository;

	public List<Fotoelectrica> findAll() {
		return fotoelectricaRepository.findAll();
	}

	public Optional<Fotoelectrica> findById(Integer id) {
		return fotoelectricaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Fotoelectrica save(Fotoelectrica entity) {
		return fotoelectricaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Fotoelectrica entity) {
		fotoelectricaRepository.delete(entity);
	}

}
	
