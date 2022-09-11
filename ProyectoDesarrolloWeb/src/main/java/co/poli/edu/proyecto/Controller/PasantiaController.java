package co.poli.edu.proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.poli.edu.proyecto.Model.Pasantia;
import co.poli.edu.proyecto.Repository.PasantiaRepository;
import co.poli.edu.proyecto.Repository.ProgramaRepository;

@RestController
@RequestMapping("/api/v1")
public class PasantiaController {
	
	@Autowired PasantiaRepository pasantiarepository;
	
	@Autowired ProgramaRepository programarepository;
	
	
	@PostMapping("/pasantia")
	public Pasantia savePasantia(@RequestBody Pasantia pasantia) {
		pasantiarepository.save(pasantia);
		return pasantia;
	}

	@PostMapping("/pasantias")
	public String savePasantia(@RequestBody List<Pasantia> pasantiasList) {
		pasantiarepository.saveAll(pasantiasList);
		return "done";
	}

}
