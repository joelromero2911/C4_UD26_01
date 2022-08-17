package mainApp.service;

import java.util.List;

import mainApp.dto.Suministra;

public interface ISuministraService {

	//Metodos del CRUD
	public List<Suministra> listarSuministran(); // Listar All 
	
	public Suministra guardarSuministra(Suministra suministra);	// CREATE
	
	public Suministra suministraXID(int id_auto); // READ
	
	public Suministra actualizarSuministran(Suministra suministra); // UPDATE
	
	public void eliminarSuministran(int id_auto); // DELETE
}
