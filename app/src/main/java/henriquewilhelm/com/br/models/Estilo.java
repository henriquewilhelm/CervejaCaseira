package henriquewilhelm.com.br.models;

import java.io.Serializable;
public class Estilo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7485554321912663630L;

	private Integer id;
	private String bjcp;
	private String categoria;
	private String nome;
	private Double gravidadeOriginalMin = 0d;
	private Double gravidadeFinalMin = 0d;
	private Double bitternessMin = 0d;
	private Double ibuPorOgMin = 0d;
	private Double balancoMin = 0d;
	private Double abvMin = 0d;
	private Double corMin = 0d;
	private Double gravidadeOriginalMax = 0d;
	private Double gravidadeFinalMax = 0d;
	private Double bitternessMax = 0d;
	private Double ibuPorOgMax = 0d;
	private Double balancoMax = 0d;
	private Double abvMax = 0d;
	private Double corMax = 0d;

	public Estilo(){

	}


	public Estilo(String nome){
		this.nome = nome;
	}

	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getGravidadeOriginalMin() {
		return gravidadeOriginalMin;
	}

	public void setGravidadeOriginalMin(Double gravidadeOriginalMin) {
		this.gravidadeOriginalMin = gravidadeOriginalMin;
	}

	public Double getGravidadeFinalMin() {
		return gravidadeFinalMin;
	}

	public void setGravidadeFinalMin(Double gravidadeFinalMin) {
		this.gravidadeFinalMin = gravidadeFinalMin;
	}

	public Double getBitternessMin() {
		return bitternessMin;
	}

	public void setBitternessMin(Double bitternessMin) {
		this.bitternessMin = bitternessMin;
	}

	public Double getIbuPorOgMin() {
		return ibuPorOgMin;
	}

	public void setIbuPorOgMin(Double ibuPorOgMin) {
		this.ibuPorOgMin = ibuPorOgMin;
	}

	public Double getBalancoMin() {
		return balancoMin;
	}

	public void setBalancoMin(Double balancoMin) {
		this.balancoMin = balancoMin;
	}

	public Double getAbvMin() {
		return abvMin;
	}

	public void setAbvMin(Double abvMin) {
		this.abvMin = abvMin;
	}

	public Double getGravidadeOriginalMax() {
		return gravidadeOriginalMax;
	}

	public void setGravidadeOriginalMax(Double gravidadeOriginalMax) {
		this.gravidadeOriginalMax = gravidadeOriginalMax;
	}

	public Double getGravidadeFinalMax() {
		return gravidadeFinalMax;
	}

	public void setGravidadeFinalMax(Double gravidadeFinalMax) {
		this.gravidadeFinalMax = gravidadeFinalMax;
	}

	public Double getBitternessMax() {
		return bitternessMax;
	}

	public void setBitternessMax(Double bitternessMax) {
		this.bitternessMax = bitternessMax;
	}

	public Double getIbuPorOgMax() {
		return ibuPorOgMax;
	}

	public void setIbuPorOgMax(Double ibuPorOgMax) {
		this.ibuPorOgMax = ibuPorOgMax;
	}

	public Double getBalancoMax() {
		return balancoMax;
	}

	public void setBalancoMax(Double balancoMax) {
		this.balancoMax = balancoMax;
	}

	public Double getAbvMax() {
		return abvMax;
	}

	public void setAbvMax(Double abvMax) {
		this.abvMax = abvMax;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCorMin() {
		return corMin;
	}

	public void setCorMin(Double corMin) {
		this.corMin = corMin;
	}

	public Double getCorMax() {
		return corMax;
	}

	public void setCorMax(Double corMax) {
		this.corMax = corMax;
	}

	public String getBjcp() {
		return bjcp;
	}

	public void setBjcp(String bjcp) {
		this.bjcp = bjcp;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
