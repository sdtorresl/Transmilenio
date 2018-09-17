package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Acondicionado;
import co.innovaciones.repository.AcondicionadoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AcondicionadoService {

	@Autowired
	private AcondicionadoRepository acondicionadoRepository;

	public List<Acondicionado> findAll() {
		return acondicionadoRepository.findAll();
	}

	public Optional<Acondicionado> findById(Integer id) {
		return acondicionadoRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Acondicionado save(Acondicionado entity) {
		return acondicionadoRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Acondicionado entity) {
		acondicionadoRepository.delete(entity);
	}

}
	
