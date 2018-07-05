package henriquewilhelm.com.br.models;

import java.io.Serializable;

public class Outros implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2727780939318141794L;

	private Integer id;
	private String nome;
	private Double gramas;
	private String uso;
	private Integer tempo;
	private String tipo;

	public Outros(){

	}

	public Outros(String nome){
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

	public Double getGramas() {
		return gramas;
	}

	public void setGramas(Double gramas) {
		this.gramas = gramas;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
