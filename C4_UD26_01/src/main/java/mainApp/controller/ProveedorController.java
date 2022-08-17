package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Proveedor;
import mainApp.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedores(){
		return proveedorServiceImpl.listarProveedores();
	}
	
	@PostMapping("/proveedores")
	public Proveedor guardarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXID(@PathVariable(name="id") String id) {
		
		Proveedor proveedor_xid= new Proveedor();
		proveedor_xid=proveedorServiceImpl.proveedorXID(id);
		System.out.println("Proveedor XID: "+proveedor_xid);
		return proveedor_xid;
	}

	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedores(@PathVariable(name="id")String id,@RequestBody Proveedor proveedor) {
		
		Proveedor proveedor_seleccionado= new Proveedor();
		Proveedor proveedor_actualizado= new Proveedor();
		
		proveedor_seleccionado= proveedorServiceImpl.proveedorXID(id);
		proveedor_seleccionado.setNombre(proveedor.getNombre());
		proveedor_seleccionado.setId(proveedor.getId());
		proveedor_actualizado = proveedorServiceImpl.actualizarProveedores(proveedor_seleccionado);
		
		System.out.println("La pieza actualizado es: "+ proveedor_actualizado);
		
		return proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedores(@PathVariable(name="id")String id) {
		proveedorServiceImpl.eliminarProveedores(id);
	}
}
