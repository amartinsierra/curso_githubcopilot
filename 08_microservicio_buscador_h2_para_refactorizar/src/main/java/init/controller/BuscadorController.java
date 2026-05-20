package init.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import init.model.Item;
import init.service.BuscadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@CrossOrigin("*")
@RequestMapping(value="buscador")
@RestController
public class BuscadorController {
	
	BuscadorService buscadorService;
	public BuscadorController(BuscadorService buscadorService) {
		this.buscadorService=buscadorService;
	}
	@Operation(summary = "busqueda de items por temática",description = "devuelve la lista de items asociados a la temática recibida como parámetro")
	@GetMapping(value="items",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Item>> items(@Parameter(description = "tematica de búsqueda") @RequestParam String tematica){
		return new ResponseEntity<>(this.buscadorService.buscarPorTematica(tematica), HttpStatus.OK);
	}
	@PostMapping(value="items",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> alta(@RequestBody Item item) {
		if(this.buscadorService.nuevoItem(item)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	@DeleteMapping(value="items")
	public ResponseEntity<Void> eliminar(@RequestParam String tematica){
		this.buscadorService.eliminarPorTematica(tematica);		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}