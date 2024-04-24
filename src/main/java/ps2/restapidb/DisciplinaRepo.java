package ps2.restapidb;

import org.springframework.data.repository.CrudRepository;

public interface DisciplinaRepo extends CrudRepository<Disciplina, Long> {
	Iterable<Disciplina> findByFaculdadeId(Long faculdadeId);
}