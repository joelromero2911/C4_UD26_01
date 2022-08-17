package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Pieza;
import mainApp.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {
	
	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
	
	@PostMapping("/piezas")
	public Pieza guardarPieza(@RequestBody Pieza pieza) {
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	@GetMapping("/piezas/{codigo}")
	public Pieza piezaXID(@PathVariable(name="codigo") int codigo) {
		
		Pieza pieza_xid= new Pieza();
		pieza_xid=piezaServiceImpl.piezaXID(codigo);
		System.out.println("Pieza XID: "+pieza_xid);
		return pieza_xid;
	}

	@PutMapping("/piezas/{codigo}")
	public Pieza actualizarPiezas(@PathVariable(name="codigo")int codigo,@RequestBody Pieza pieza) {
		
		Pieza pieza_seleccionado= new Pieza();
		Pieza pieza_actualizado= new Pieza();
		
		pieza_seleccionado= piezaServiceImpl.piezaXID(codigo);
		pieza_seleccionado.setNombre(pieza.getNombre());
		pieza_actualizado = piezaServiceImpl.actualizarPiezas(pieza_seleccionado);
		
		System.out.println("La pieza actualizado es: "+ pieza_actualizado);
		
		return pieza_actualizado;
	}
	
	@DeleteMapping("/piezas/{codigo}")
	public void eliminarPiezas(@PathVariable(name="codigo")int codigo) {
		piezaServiceImpl.eliminarPiezas(codigo);
	}
}
