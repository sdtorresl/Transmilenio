package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Neopreno;
import co.innovaciones.repository.NeoprenoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NeoprenoService {

	@Autowired
	private NeoprenoRepository neoprenoRepository;

	public List<Neopreno> findAll() {
		return neoprenoRepository.findAll();
	}

	public Optional<Neopreno> findById(Integer id) {
		return neoprenoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Neopreno save(Neopreno entity) {
		return neoprenoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Neopreno entity) {
		neoprenoRepository.delete(entity);
	}

}
	
