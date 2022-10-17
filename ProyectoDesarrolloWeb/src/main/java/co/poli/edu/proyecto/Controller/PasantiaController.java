package co.poli.edu.proyecto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.poli.edu.proyecto.Model.Pasantia;
import co.poli.edu.proyecto.Model.Programa;
import co.poli.edu.proyecto.Repository.PasantiaRepository;
import co.poli.edu.proyecto.Repository.ProgramaRepository;

@RestController
@RequestMapping("/api/v1")
public class PasantiaController {
	
	@Autowired PasantiaRepository pasantiaRepository;
	
	@Autowired ProgramaRepository programaRepository;
	

	@GetMapping("/pasantia/{id_pasantia}")
	public Pasantia visualizarPasantia(@PathVariable Integer id_pasantia) {
		Pasantia a = pasantiaRepository.findById(id_pasantia).get();
		return a;
	}
	
	@GetMapping("/pasantia")
	public List<Pasantia> getPasantia(Integer id_pasantia) {
		return pasantiaRepository.findAll();
	}

	@PostMapping("/pasantia")
	public Pasantia savePasantia(@RequestBody Pasantia pasantia) {
		pasantiaRepository.save(pasantia);
		return pasantia;
	}

	@PostMapping("/pasantias")
	public String savePasantia(@RequestBody List<Pasantia> pasantiasList) {
		pasantiaRepository.saveAll(pasantiasList);
		return "done";
	}
	
	@PutMapping("/pasantia/{id_pasantia}")
	public Pasantia actualizarPasantia(@PathVariable Integer id_pasantia, @RequestBody Pasantia pasantia) {

		Pasantia a = visualizarPasantia(id_pasantia);

		a.setLugar(pasantia.getLugar());
		a.setFecha(pasantia.getFecha());
		a.setHora(pasantia.getHora());
		a.setId_estudiante(pasantia.getId_estudiante());
		a.setNombre_estudiante(pasantia.getNombre_estudiante());
		a.setSemestre(pasantia.getSemestre());

		pasantiaRepository.save(a);
		return a;
	}
	
	
	@DeleteMapping("/pasantia/{id_pasantia}")
	public Pasantia eliminarPasantia(@PathVariable Integer id_pasantia) {
		Pasantia a = visualizarPasantia(id_pasantia);
		pasantiaRepository.deleteById(id_pasantia);
		return a;
	}
	
	@PutMapping("/pasantia/{idC}/{idI}")
	public Pasantia associate(@PathVariable int idC, @PathVariable String idI) {
		
		Pasantia pasantia = pasantiaRepository.findById(idC).get();
		Programa programa = programaRepository.findById(idI).get();
		

		programa.getPasantias().add(pasantia);
		pasantia.setPrograma(programa);
		
		pasantiaRepository.save(pasantia);
		return pasantia;
	}

}
