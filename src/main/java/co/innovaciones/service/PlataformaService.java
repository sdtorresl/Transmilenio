package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Plataforma;
import co.innovaciones.repository.PlataformaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PlataformaService {

	@Autowired
	private PlataformaRepository plataformaRepository;

	public List<Plataforma> findAll() {
		return plataformaRepository.findAll();
	}

	public Optional<Plataforma> findById(Integer id) {
		return plataformaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Plataforma save(Plataforma entity) {
		return plataformaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Plataforma entity) {
		plataformaRepository.delete(entity);
	}

}
	
