package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Subplataforma;
import co.innovaciones.repository.SubplataformaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SubplataformaService {

	@Autowired
	private SubplataformaRepository subplataformaRepository;

	public List<Subplataforma> findAll() {
		return subplataformaRepository.findAll();
	}

	public Optional<Subplataforma> findById(Integer id) {
		return subplataformaRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Subplataforma save(Subplataforma entity) {
		return subplataformaRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Subplataforma entity) {
		subplataformaRepository.delete(entity);
	}

}
	
