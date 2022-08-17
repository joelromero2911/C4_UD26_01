package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.ISuministraDAO;
import mainApp.dto.Suministra;

@Service
public class SuministraServiceImpl implements ISuministraService{

	@Autowired
	ISuministraDAO iSuministraDAO;
	
	@Override
	public List<Suministra> listarSuministran() {
		return iSuministraDAO.findAll();
	}

	@Override
	public Suministra guardarSuministra(Suministra suministra) {
		return iSuministraDAO.save(suministra);
	}

	@Override
	public Suministra suministraXID(int id_auto) {
		return iSuministraDAO.findById(id_auto).get();
	}

	@Override
	public Suministra actualizarSuministran(Suministra suministra) {
		return iSuministraDAO.save(suministra);
	}

	@Override
	public void eliminarSuministran(int id_auto) {
		iSuministraDAO.deleteById(id_auto);
	}

}
