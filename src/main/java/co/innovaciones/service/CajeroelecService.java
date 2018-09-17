package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Cajeroelec;
import co.innovaciones.repository.CajeroelecRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CajeroelecService {

	@Autowired
	private CajeroelecRepository cajeroelecRepository;

	public List<Cajeroelec> findAll() {
		return cajeroelecRepository.findAll();
	}

	public Optional<Cajeroelec> findById(Integer id) {
		return cajeroelecRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Cajeroelec save(Cajeroelec entity) {
		return cajeroelecRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Cajeroelec entity) {
		cajeroelecRepository.delete(entity);
	}

}
	
