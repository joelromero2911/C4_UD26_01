package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Pieza;

public interface IPiezaDAO extends JpaRepository<Pieza, Integer>{

}
