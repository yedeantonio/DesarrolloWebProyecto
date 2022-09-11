package co.poli.edu.proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.poli.edu.proyecto.Repository.ProgramaRepository;
import co.poli.edu.proyecto.Model.Programa;

@RestController
@RequestMapping("/api/v1")
public class ProgramaController {
	
	@Autowired ProgramaRepository programarepository;
	
	@PostMapping("/programa")
	public Programa savePrograma(@RequestBody Programa programa) {
		programarepository.save(programa);
		return programa;
	}

	@PostMapping("/programas")
	public String saveProgramas(@RequestBody List<Programa> programaslist) {
		programarepository.saveAll(programaslist);
		return "done";
	}
	


}
