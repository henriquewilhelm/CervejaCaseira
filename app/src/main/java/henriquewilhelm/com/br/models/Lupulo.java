package henriquewilhelm.com.br.models;

import java.io.Serializable;

public class Lupulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 658327184685969908L;

	private Integer id;
	private String nome;
	private Double alphaAcidos = 0d;
	private Double relacaoGramasPorLitro = 0d;
	private Double percentagem = 0d;
	private Double gramas = 0d;
	private String uso = "Boil";
	private Integer tempo = 0;
	private Double ibu = 0d;
	private String tipo  = "Pellet";
	
	public Lupulo(){
		
	}
	
	public Lupulo(Integer id, String nome, Double alphaAcidos,
			Double relacaoGramasPorLitro, Double percentagem, Double gramas,
			String uso, Integer tempo, Double ibu, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.alphaAcidos = alphaAcidos;
		this.relacaoGramasPorLitro = relacaoGramasPorLitro;
		this.percentagem = percentagem;
		this.gramas = gramas;
		this.uso = uso;
		this.tempo = tempo;
		this.ibu = ibu;
		this.tipo = tipo;
	}

	public Lupulo(String nome){
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

	public Double getAlphaAcidos() {
		return alphaAcidos;
	}

	public void setAlphaAcidos(Double alphaAcidos) {
		this.alphaAcidos = alphaAcidos;
	}

	public Double getRelacaoGramasPorLitro() {
		return relacaoGramasPorLitro;
	}

	public void setRelacaoGramasPorLitro(Double relacaoGramasPorLitro) {
		this.relacaoGramasPorLitro = relacaoGramasPorLitro;
	}

	public Double getPercentagem() {
		return percentagem;
	}

	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
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

	public Double getIbu() {
		return ibu;
	}

	public void setIbu(Double ibu) {
		this.ibu = ibu;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
