package co.innovaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import co.innovaciones.model.Toteminfor;
import co.innovaciones.repository.ToteminforRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ToteminforService {

	@Autowired
	private ToteminforRepository toteminforRepository;

	public List<Toteminfor> findAll() {
		return toteminforRepository.findAll();
	}

	public Optional<Toteminfor> findById(Integer id) {
		return toteminforRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Toteminfor save(Toteminfor entity) {
		return toteminforRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Toteminfor entity) {
		toteminforRepository.delete(entity);
	}

}
	
