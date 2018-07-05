package henriquewilhelm.com.br.models;

import java.io.Serializable;
public class Fermento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6627723978895439459L;

	private Integer id;
	private String nome;
	
	private String brand;
	private String categoria;
	private Double atenuacao = 75d;
	private String floculacao; 
	private Double minTemp;
	private Double maxTemp;
	private String alcoolTolerancia;

	public Fermento(){
	}

	public Fermento(String nome){
		this.nome = nome;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getAtenuacao() {
		return atenuacao;
	}

	public void setAtenuacao(Double atenuacao) {
		this.atenuacao = atenuacao;
	}

	public String getFloculacao() {
		return floculacao;
	}

	public void setFloculacao(String floculacao) {
		this.floculacao = floculacao;
	}

	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public String getAlcoolTolerancia() {
		return alcoolTolerancia;
	}

	public void setAlcoolTolerancia(String alcoolTolerancia) {
		this.alcoolTolerancia = alcoolTolerancia;
	}

	
}
