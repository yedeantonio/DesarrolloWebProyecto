package co.poli.edu.proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.poli.edu.proyecto.Repository.ProgramaRepository;
import co.edu.poli.act2.model.Book;
import co.poli.edu.proyecto.Model.Programa;

@RestController
@RequestMapping("/api/v1")
public class ProgramaController {
	
	@Autowired ProgramaRepository programaRepository;
	
	@GetMapping("/programa")
	public List<Programa> getPrograma() {
		return programaRepository.findAll();
	}

	@GetMapping("/programa/{num_programa}")
	public Programa get(@PathVariable String num_programa) {
		Programa a = programaRepository.findById(num_programa).get();
		return a;
	}
	
	@PostMapping("/programa")
	public Programa savePrograma(@RequestBody Programa programa) {
		programaRepository.save(programa);
		return programa;
	}

	@PostMapping("/programas")
	public String saveProgramas(@RequestBody List<Programa> programaslist) {
		programaRepository.saveAll(programaslist);
		return "done";
	}
	
	@PutMapping("/programa/{num_programa}")
	public Programa actualizarPrograma(@PathVariable String num_programa, @RequestBody Programa programa) {

		Programa a = get(num_programa);

		a.setNombre(programa.getNombre());
		a.setFacultad(programa.getFacultad());
		a.setEscuela(programa.getEscuela());

		programaRepository.save(a);
		return a;
	}


}
