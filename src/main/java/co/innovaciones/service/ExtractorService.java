package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Extractor;
import co.innovaciones.repository.ExtractorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ExtractorService {

	@Autowired
	private ExtractorRepository extractorRepository;

	public List<Extractor> findAll() {
		return extractorRepository.findAll();
	}

	public Optional<Extractor> findById(Integer id) {
		return extractorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Extractor save(Extractor entity) {
		return extractorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Extractor entity) {
		extractorRepository.delete(entity);
	}

}
	
