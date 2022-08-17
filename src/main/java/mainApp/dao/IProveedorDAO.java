package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Proveedor;

public interface IProveedorDAO extends JpaRepository<Proveedor, String>{

}
