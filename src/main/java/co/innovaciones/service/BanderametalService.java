package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Banderametal;
import co.innovaciones.repository.BanderametalRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BanderametalService {

	@Autowired
	private BanderametalRepository banderametalRepository;

	public List<Banderametal> findAll() {
		return banderametalRepository.findAll();
	}

	public Optional<Banderametal> findById(Integer id) {
		return banderametalRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Banderametal save(Banderametal entity) {
		return banderametalRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Banderametal entity) {
		banderametalRepository.delete(entity);
	}

}
	
