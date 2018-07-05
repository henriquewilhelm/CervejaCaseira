package henriquewilhelm.com.br.models;

import java.io.Serializable;
public class Temperaturas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805016469661080115L;

	private Integer id;
	private String nomeEnzimas;
	private Double temperaturaMin = 0d;
	private Double temperaturaMax = 0d;
	private Double temperatura = 0d;
	private Double phMin = 0d;
	private Double phMax = 0d;
	private Integer tempo = 0;
	private String unidade;
	private String sobre;

	public Temperaturas(){

	}

	public Temperaturas(String nome){
		this.nomeEnzimas = nome;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	public String getNomeEnzimas() {
		return nomeEnzimas;
	}

	public void setNomeEnzimas(String nomeEnzimas) {
		this.nomeEnzimas = nomeEnzimas;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Double getTemperaturaMin() {
		return temperaturaMin;
	}

	public void setTemperaturaMin(Double temperatura) {
		this.temperaturaMin = temperatura;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Double getPhMin() {
		return phMin;
	}

	public void setPhMin(Double pH) {
		this.phMin = pH;
	}
	
	public Double getTemperaturaMax() {
		return temperaturaMax;
	}

	public void setTemperaturaMax(Double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}
	
	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getPhMax() {
		return phMax;
	}

	public void setPhMax(Double phMax) {
		this.phMax = phMax;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}
}
