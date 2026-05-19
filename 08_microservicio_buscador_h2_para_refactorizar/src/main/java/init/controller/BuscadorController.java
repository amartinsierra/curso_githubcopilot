package init.controller;

import java.util.List;

import org.springframework.http.MediaType;
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
	public List<Item> items(@Parameter(description = "tematica de búsqueda") @RequestParam String tematica){
		return this.buscadorService.buscarPorTematica(tematica);
	}
	@PostMapping(value="items",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Item item) {
		this.buscadorService.nuevoItem(item);
	}
	@DeleteMapping(value="items")
	public void eliminar(@RequestParam String tematica){
		this.buscadorService.eliminarPorTematica(tematica);		
	}
}
