package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Casetacomercial;
import co.innovaciones.repository.CasetacomercialRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CasetacomercialService {

	@Autowired
	private CasetacomercialRepository casetacomercialRepository;

	public List<Casetacomercial> findAll() {
		return casetacomercialRepository.findAll();
	}

	public Optional<Casetacomercial> findById(Integer id) {
		return casetacomercialRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Casetacomercial save(Casetacomercial entity) {
		return casetacomercialRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Casetacomercial entity) {
		casetacomercialRepository.delete(entity);
	}

}
	
