package henriquewilhelm.com.br.models;

import java.io.Serializable;
public class Graos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6627723978895439459L;

	private Integer id;
	private String nome;
	private Double potencialExtracao = 0d;
	private Double cor = 0d;
	private Double percentagem = 0d;
	private Double kilos = 0d;
	private boolean mashable = true;
	private boolean adicaoTardia = false;
	
	public Graos(){
		
	}

	public Graos(String nome){
		this.nome = nome;
	}
	
	public Graos(Integer id, String nome, Double potencialExtracao, Double cor,
			Double percentagem, Double kilos, boolean mashable,
			boolean adicaoTardia) {
		super();
		this.id = id;
		this.nome = nome;
		this.potencialExtracao = potencialExtracao;
		this.cor = cor;
		this.percentagem = percentagem;
		this.kilos = kilos;
		this.mashable = mashable;
		this.adicaoTardia = adicaoTardia;
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

	public Double getPotencialExtracao() {
		return potencialExtracao;
	}

	public void setPotencialExtracao(Double potencialExtracao) {
		this.potencialExtracao = potencialExtracao;
	}

	public Double getCor() {
		return cor;
	}

	public void setCor(Double cor) {
		this.cor = cor;
	}

	public Double getPercentagem() {
		return percentagem;
	}

	public void setPercentagem(Double percentagem) {
		this.percentagem = percentagem;
	}

	public Double getKilos() {
		return kilos;
	}

	public void setKilos(Double kilos) {
		this.kilos = kilos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isMashable() {
		return mashable;
	}

	public void setMashable(boolean mashable) {
		this.mashable = mashable;
	}

	public boolean isAdicaoTardia() {
		return adicaoTardia;
	}

	public void setAdicaoTardia(boolean adicaoTardia) {
		this.adicaoTardia = adicaoTardia;
	}

	@Override
	public String toString() {
		return "Graos{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", potencialExtracao=" + potencialExtracao +
				", cor=" + cor +
				", percentagem=" + percentagem +
				", kilos=" + kilos +
				", mashable=" + mashable +
				", adicaoTardia=" + adicaoTardia +
				'}';
	}
}
