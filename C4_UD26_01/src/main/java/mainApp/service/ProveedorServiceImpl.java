package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IProveedorDAO;
import mainApp.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	IProveedorDAO iProveedorDAO;
	
	@Override
	public List<Proveedor> listarProveedores() {
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor proveedorXID(String id) {
		return iProveedorDAO.findById(id).get();
	}

	@Override
	public Proveedor actualizarProveedores(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedores(String id) {
		iProveedorDAO.deleteById(id);
	}

}
