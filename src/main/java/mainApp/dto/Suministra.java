package mainApp.dto;

import javax.persistence.*;

@Entity
@Table(name="suministra")
public class Suministra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_auto;
	
	@ManyToOne
	@JoinColumn(name="codigo_pieza")
	private Pieza pieza;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	
	@Column(name = "precio")
	private int precio;

	/**
	 * 
	 */
	public Suministra() {
	}

	/**
	 * @param id_auto
	 * @param pieza
	 * @param proveedor
	 * @param precio
	 */
	public Suministra(int id_auto, Pieza pieza, Proveedor proveedor, int precio) {
		super();
		this.id_auto = id_auto;
		this.pieza = pieza;
		this.proveedor = proveedor;
		this.precio = precio;
	}

	/**
	 * @return the id_auto
	 */
	public int getId_auto() {
		return id_auto;
	}

	/**
	 * @param id_auto the id_auto to set
	 */
	public void setId_auto(int id_auto) {
		this.id_auto = id_auto;
	}

	/**
	 * @return the pieza
	 */
	public Pieza getPieza() {
		return pieza;
	}

	/**
	 * @param pieza the pieza to set
	 */
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Suministra [id_auto=" + id_auto + ", pieza=" + pieza + ", proveedor=" + proveedor + ", precio=" + precio
				+ "]";
	}

}
