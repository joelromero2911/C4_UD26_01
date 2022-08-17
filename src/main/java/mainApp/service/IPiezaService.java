package mainApp.service;

import java.util.List;

import mainApp.dto.Pieza;

public interface IPiezaService {
	//Metodos del CRUD
	public List<Pieza> listarPiezas(); // Listar All 
	
	public Pieza guardarPieza(Pieza pieza);	// CREATE
	
	public Pieza piezaXID(int codigo); // READ
	
	public Pieza actualizarPiezas(Pieza pieza); // UPDATE
	
	public void eliminarPiezas(int codigo); // DELETE
}
