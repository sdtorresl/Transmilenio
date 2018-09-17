package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Logo;
import co.innovaciones.repository.LogoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LogoService {

	@Autowired
	private LogoRepository logoRepository;

	public List<Logo> findAll() {
		return logoRepository.findAll();
	}

	public Optional<Logo> findById(Integer id) {
		return logoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Logo save(Logo entity) {
		return logoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Logo entity) {
		logoRepository.delete(entity);
	}

}
	
