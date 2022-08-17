package mainApp.service;

import java.util.List;

import mainApp.dto.Proveedor;

public interface IProveedorService {
	//Metodos del CRUD
	public List<Proveedor> listarProveedores(); // Listar All 
	
	public Proveedor guardarProveedor(Proveedor proveedor);	// CREATE
	
	public Proveedor proveedorXID(String id); // READ
	
	public Proveedor actualizarProveedores(Proveedor proveedor); // UPDATE
	
	public void eliminarProveedores(String id); // DELETE
}