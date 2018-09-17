package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Medidor;
import co.innovaciones.repository.MedidorRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MedidorService {

	@Autowired
	private MedidorRepository medidorRepository;

	public List<Medidor> findAll() {
		return medidorRepository.findAll();
	}

	public Optional<Medidor> findById(Integer id) {
		return medidorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Medidor save(Medidor entity) {
		return medidorRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Medidor entity) {
		medidorRepository.delete(entity);
	}

}
	
