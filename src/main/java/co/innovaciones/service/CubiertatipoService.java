package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Cubiertatipo;
import co.innovaciones.repository.CubiertatipoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CubiertatipoService {

	@Autowired
	private CubiertatipoRepository cubiertatipoRepository;

	public List<Cubiertatipo> findAll() {
		return cubiertatipoRepository.findAll();
	}

	public Optional<Cubiertatipo> findById(Integer id) {
		return cubiertatipoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Cubiertatipo save(Cubiertatipo entity) {
		return cubiertatipoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Cubiertatipo entity) {
		cubiertatipoRepository.delete(entity);
	}

}
	
