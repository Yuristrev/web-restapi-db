package ps2.restapidb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class DisciplinaController {

	@Autowired
	private DisciplinaRepo DisciplinaRepo;

	public DisciplinaController() {

	}

	@GetMapping("/api/disciplina")
	Iterable<Disciplina> getDisciplina(@RequestParam Optional<Long> faculdadeId) {
		if (faculdadeId.isEmpty()) {
			return DisciplinaRepo.findAll();			
		}
		return DisciplinaRepo.findByFaculdadeId(faculdadeId.get());
	}
	
	@GetMapping("/api/disciplina/{id}")
	Optional<Disciplina> getDisciplina(@PathVariable long id) {
		return DisciplinaRepo.findById(id);
	}
	
	@PostMapping("/api/disciplina")
	Disciplina createDisciplina(@RequestBody Disciplina d) {
		Disciplina createdDisc = DisciplinaRepo.save(d);
		return createdDisc;
	}
	
	@PutMapping("/api/disciplina/{disciplinaId}")
	Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable long disciplinaId) {
		Optional<Disciplina> opt = DisciplinaRepo.findById(disciplinaId);
		if (opt.isPresent()) {
			if (disciplinaRequest.getId() == disciplinaId) {
				DisciplinaRepo.save(disciplinaRequest);
				return opt;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao alterar dados de disciplina com id " + disciplinaId);	
	}	
	
	@DeleteMapping(value = "/api/disciplina/{id}")
	void deleteDisciplina(@PathVariable long id) {
		DisciplinaRepo.deleteById(id);
	}		
}