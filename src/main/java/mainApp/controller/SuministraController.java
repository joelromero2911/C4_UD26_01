package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Suministra;
import mainApp.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministran")
	public List<Suministra> listarSuministran(){
		return suministraServiceImpl.listarSuministran();
	}
	
	@PostMapping("/suministran")
	public Suministra guardarSuministra(@RequestBody Suministra suministra) {
		return suministraServiceImpl.guardarSuministra(suministra);
	}
	
	@GetMapping("/suministran/{id_auto}")
	public Suministra suministraXID(@PathVariable(name="id_auto") int id_auto) {
		
		Suministra suministra_xid= new Suministra();
		suministra_xid=suministraServiceImpl.suministraXID(id_auto);
		System.out.println("Proveedor XID: "+suministra_xid);
		return suministra_xid;
	}

	@PutMapping("/suministran/{id_auto}")
	public Suministra actualizarSuministran(@PathVariable(name="id_auto")int id_auto,@RequestBody Suministra suministra) {
		
		Suministra suministra_seleccionado= new Suministra();
		Suministra suministra_actualizado= new Suministra();
		
		suministra_seleccionado= suministraServiceImpl.suministraXID(id_auto);
		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setProveedor(suministra.getProveedor());
		suministra_seleccionado.setPrecio(suministra.getPrecio());
		suministra_actualizado = suministraServiceImpl.actualizarSuministran(suministra_seleccionado);
		
		System.out.println("Suministra actualizado es: "+ suministra_actualizado);
		
		return suministra_actualizado;
	}
	
	@DeleteMapping("/suministran/{id_auto}")
	public void eliminarSuministran(@PathVariable(name="id_auto")int id_auto) {
		suministraServiceImpl.eliminarSuministran(id_auto);
	}
}
