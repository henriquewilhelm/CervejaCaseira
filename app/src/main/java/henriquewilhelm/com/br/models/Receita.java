package henriquewilhelm.com.br.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Root
public class Receita implements Serializable {

	private static final long serialVersionUID = 4024666317611614641L;

	private Integer id;
	@Element
	private String nome;
	@Element
	private List<Graos> graos;
	private List<Lupulo> lupulos;
	private List<Outros> outros;
	private List<Temperaturas> temperaturas;
	private Fermento fermento;
	private Estilo estilo;
	private Double quantidadeLitros = 20d;
	private Double quantidadeGraos = 0d;
	private Double quantidadeLupulo = 0d;
	private Double eficiencia = 75d;
	private Double gravidadeOriginal = 0d;
	private Double gravidadeFinal = 0d;
	private Double bitterness = 0d;
	private Double ibuPorOg = 0d;
	private Double balanco = 0d;
	private Double abv = 0d;
	private Double cor = 0d;
	private Integer tempoBrassagem = 60;
	private Integer tempoFervura = 60;
	private Double temperaturaBrassagem = 68d;
	private String unidade;
	private Double calorias;
	private String escalaAcucar = "densidade";
	private Double qntdTotalLitros = 0d;
	private Double qntdInicialLitros = 0d;
	private Double qntdLavagemLitros = 0d;
	private Double perdaPanelaBrassagem = 2.5d;
	private Double perdaPanelaFervura = 2.5d;
	private Double perdaFermentador = 1.5d;
	private Double taxaEvaporacao = 15d;
	private Double taxaContracao = 0.04d;
	private Double temperaturaGraos = 20d;
	private Double absorcaoGraos = 1d;
	private Double qntdTotalMostoLitros = 0d;
	private Double temperaturaInicial = 55d;
	private Double temperaturaLavagemDesejada = 75d;
	private Double temperaturaLavagemIdeal = 0d;
	private Double relacaoAguaGrao = 3d;
	//fervura
	private Double percentagemGraos = 0d;
	private Double quantidadeAntesFerver = 0d;
	private Double sgAntesFerver = 0d;
	private Double quantidadeDepoisFerver = 0d;
	private Double sdDepoisFerver = 0d;
	private Double volumeAntesEsfriar = 0d;

	public Receita(){
		this.estilo = new Estilo();
		this.graos = new ArrayList<Graos>();
		this.lupulos = new ArrayList<Lupulo>();
		this.outros = new ArrayList<Outros>();
		this.temperaturas = new ArrayList<Temperaturas>();
		this.fermento = new Fermento();
	}

	public Receita(Integer id, String nome, List<Graos> graos,
			List<Lupulo> lupulos, List<Outros> outros,
			List<Temperaturas> temperaturas, Estilo estilo,
			Double quantidadeLitros, Double quantidadeGraos,
			Double quantidadeLupulo, Double eficiencia,
			Double gravidadeOriginal, Double gravidadeFinal, Double bitterness,
			Double ibuPorOg, Double balanco, Double abv, Double cor) {
		super();
		this.id = id;
		this.nome = nome;
		this.graos = graos;
		this.lupulos = lupulos;
		this.outros = outros;
		this.temperaturas = temperaturas;
		this.estilo = estilo;
		this.quantidadeLitros = quantidadeLitros;
		this.quantidadeGraos = quantidadeGraos;
		this.quantidadeLupulo = quantidadeLupulo;
		this.eficiencia = eficiencia;
		this.gravidadeOriginal = gravidadeOriginal;
		this.gravidadeFinal = gravidadeFinal;
		this.bitterness = bitterness;
		this.ibuPorOg = ibuPorOg;
		this.balanco = balanco;
		this.abv = abv;
		this.cor = cor;
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
	public List<Graos> getGraos() {
		return graos;
	}
	public void setGraos(List<Graos> graos) {
		this.graos = graos;
	}
	public List<Lupulo> getLupulos() {
		return lupulos;
	}
	public void setLupulos(List<Lupulo> lupulos) {
		this.lupulos = lupulos;
	}
	public Estilo getEstilo() {
		return estilo;
	}
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
	public Double getQuantidadeLitros() {
		return quantidadeLitros;
	}
	public void setQuantidadeLitros(Double quantidadeLitros) {
		this.quantidadeLitros = quantidadeLitros;
	}
	public Double getQuantidadeGraos() {
		return quantidadeGraos;
	}
	public void setQuantidadeGraos(Double quantidadeGraos) {
		this.quantidadeGraos = quantidadeGraos;
	}
	public Double getQuantidadeLupulo() {
		return quantidadeLupulo;
	}
	public void setQuantidadeLupulo(Double quantidadeLupulo) {
		this.quantidadeLupulo = quantidadeLupulo;
	}
	public Double getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(Double eficiencia) {
		this.eficiencia = eficiencia;
	}
	public Double getGravidadeOriginal() {
		return gravidadeOriginal;
	}

	public void setGravidadeOriginal(Double gravidadeOriginal) {
		this.gravidadeOriginal = gravidadeOriginal;
	}
	public Double getGravidadeFinal() {
		return gravidadeFinal;
	}

	public void setGravidadeFinal(Double gravidadeFinal) {
		this.gravidadeFinal = gravidadeFinal;
	}

	public Double getBitterness() {
		return bitterness;
	}

	public void setBitterness(Double bitterness) {
		this.bitterness = bitterness;
	}
	public Double getIbuPorOg() {
		return ibuPorOg;
	}
	public void setIbuPorOg(Double ibuPorOg) {
		this.ibuPorOg = ibuPorOg;
	}
	public Double getBalanco() {
		return balanco;
	}
	public void setBalanco(Double balanco) {
		this.balanco = balanco;
	}
	public Double getAbv() {
		return abv;
	}

	public void setAbv(Double abv) {
		this.abv = abv;
	}
	public Double getCor() {
		return cor;
	}

	public void setCor(Double cor) {
		this.cor = cor;
	}
	public List<Outros> getOutros() {
		return outros;
	}
	public void setOutros(List<Outros> outros) {
		this.outros = outros;
	}
	public List<Temperaturas> getTemperaturas() {
		return temperaturas;
	}
	public void setTemperaturas(List<Temperaturas> temperaturas) {
		this.temperaturas = temperaturas;
	}

	public Integer getTempoBrassagem() {
		return tempoBrassagem;
	}

	public void setTempoBrassagem(Integer tempoBrassagem) {
		this.tempoBrassagem = tempoBrassagem;
	}

	public Integer getTempoFervura() {
		return tempoFervura;
	}

	public void setTempoFervura(Integer tempoFervura) {
		this.tempoFervura = tempoFervura;
	}

	public Double getTemperaturaBrassagem() {
		return temperaturaBrassagem;
	}

	public void setTemperaturaBrassagem(Double temperaturaBrassagem) {
		this.temperaturaBrassagem = temperaturaBrassagem;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Double getCalorias() {
		return calorias;
	}

	public void setCalorias(Double calorias) {
		this.calorias = calorias;
	}

	public String getEscalaAcucar() {
		return escalaAcucar;
	}

	public void setEscalaAcucar(String escalaAcucar) {
		this.escalaAcucar = escalaAcucar;
	}

	public Fermento getFermento() {
		return fermento;
	}

	public void setFermento(Fermento fermento) {
		this.fermento = fermento;
	}

	public Double getTemperaturaGraos() {
		return temperaturaGraos;
	}

	public void setTemperaturaGraos(Double temperaturaGraos) {
		this.temperaturaGraos = temperaturaGraos;
	}

	public Double getAbsorcaoGraos() {
		return absorcaoGraos;
	}

	public void setAbsorcaoGraos(Double absorcaoGraos) {
		this.absorcaoGraos = absorcaoGraos;
	}

	public Double getQntdTotalMostoLitros() {
		return qntdTotalMostoLitros;
	}

	public void setQntdTotalMostoLitros(Double volumeTotal) {
		this.qntdTotalMostoLitros = volumeTotal;
	}

	public Double getTemperaturaInicial() {
		return temperaturaInicial;
	}

	public void setTemperaturaInicial(Double temperaturaInicial) {
		this.temperaturaInicial = temperaturaInicial;
	}

	public Double getTemperaturaLavagemDesejada() {
		return temperaturaLavagemDesejada;
	}

	public void setTemperaturaLavagemDesejada(Double temperaturaLavagemDesejada) {
		this.temperaturaLavagemDesejada = temperaturaLavagemDesejada;
	}

	public Double getTemperaturaLavagemIdeal() {
		return temperaturaLavagemIdeal;
	}

	public void setTemperaturaLavagemIdeal(Double temperaturaLavagemIdeal) {
		this.temperaturaLavagemIdeal = temperaturaLavagemIdeal;
	}

	public Double getPercentagemGraos() {
		return percentagemGraos;
	}

	public void setPercentagemGraos(Double percentagemGraos) {
		this.percentagemGraos = percentagemGraos;
	}

	public Double getQuantidadeAntesFerver() {
		return quantidadeAntesFerver;
	}

	public void setQuantidadeAntesFerver(Double quantidadeAntesFerver) {
		this.quantidadeAntesFerver = quantidadeAntesFerver;
	}

	public Double getSgAntesFerver() {
		return sgAntesFerver;
	}

	public void setSgAntesFerver(Double sgAntesFerver) {
		this.sgAntesFerver = sgAntesFerver;
	}

	public Double getQuantidadeDepoisFerver() {
		return quantidadeDepoisFerver;
	}

	public void setQuantidadeDepoisFerver(Double quantidadeDepoisFerver) {
		this.quantidadeDepoisFerver = quantidadeDepoisFerver;
	}

	public Double getSdDepoisFerver() {
		return sdDepoisFerver;
	}

	public void setSdDepoisFerver(Double sdDepoisFerver) {
		this.sdDepoisFerver = sdDepoisFerver;
	}

	public Double getVolumeAntesEsfriar() {
		return volumeAntesEsfriar;
	}

	public void setVolumeAntesEsfriar(Double volumeAntesEsfriar) {
		this.volumeAntesEsfriar = volumeAntesEsfriar;
	}

	public String getVerificaOG(){
		if (estilo!=null && gravidadeOriginal != null){
			if (gravidadeOriginal >= estilo.getGravidadeOriginalMin() && gravidadeOriginal <= estilo.getGravidadeOriginalMax())
				return "color:Green;";
		}
		return "color:Black;background:Yellow;";
	}

	public String getVerificaFG(){
		if (estilo!=null && gravidadeFinal != null){
			if (gravidadeFinal >= estilo.getGravidadeFinalMin() && gravidadeFinal <= estilo.getGravidadeFinalMax())
				return "color:Green;";
		}
		return "color:Black;background:Yellow;";
	}

	public String getVerificaABV(){
		if (estilo!=null && abv != null){
			if (abv >= estilo.getAbvMin() && abv <= estilo.getAbvMax())
				return "color:Green;";
		}
		return "color:Black;background:Yellow;";
	}

	public String getVerificaCOR(){
		if (estilo!=null && cor!= null){
			if (cor >= estilo.getCorMin() && cor <= estilo.getCorMax())
				return "color:Green;";
		}
		return "color:Black;background:Yellow;";
	}

	public String getVerificaIbuPorOg(){
		if (estilo != null && estilo.getIbuPorOgMin() != null && estilo.getIbuPorOgMax() != null){

			if (ibuPorOg >= estilo.getIbuPorOgMin() && ibuPorOg <= estilo.getIbuPorOgMax())
				return "color:Green;";
		}
		return "color:Black;background:Yellow;";
	}

	public String getVerificaIBU(){
		if (estilo!=null && bitterness != null){
			if (bitterness >= estilo.getBitternessMin() && bitterness <= estilo.getBitternessMax())
				return "color:Green;";
		}
		return "color:Black;background:Yellow;";
	}

	public Double getQntdTotalLitros() {
		return qntdTotalLitros;
	}

	public void setQntdTotalLitros(Double qntdTotalLitros) {
		this.qntdTotalLitros = qntdTotalLitros;
	}

	public Double getQntdInicialLitros() {
		return qntdInicialLitros;
	}

	public void setQntdInicialLitros(Double qntdInicialLitros) {
		this.qntdInicialLitros = qntdInicialLitros;
	}

	public Double getQntdLavagemLitros() {
		return qntdLavagemLitros;
	}

	public void setQntdLavagemLitros(Double qntdLLavagemLitros) {
		this.qntdLavagemLitros = qntdLLavagemLitros;
	}

	public Double getPerdaPanelaBrassagem() {
		return perdaPanelaBrassagem;
	}

	public void setPerdaPanelaBrassagem(Double perdaPanelaBrassagem) {
		this.perdaPanelaBrassagem = perdaPanelaBrassagem;
	}

	public Double getPerdaPanelaFervura() {
		return perdaPanelaFervura;
	}

	public void setPerdaPanelaFervura(Double perdaPanelaFervura) {
		this.perdaPanelaFervura = perdaPanelaFervura;
	}

	public Double getPerdaFermentador() {
		return perdaFermentador;
	}

	public void setPerdaFermentador(Double perdaFermentador) {
		this.perdaFermentador = perdaFermentador;
	}

	public Double getTaxaEvaporacao() {
		return taxaEvaporacao;
	}

	public void setTaxaEvaporacao(Double taxaEvaporacao) {
		this.taxaEvaporacao = taxaEvaporacao;
	}

	public Double getTaxaContracao() {
		return taxaContracao;
	}

	public void setTaxaContracao(Double taxaContracao) {
		this.taxaContracao = taxaContracao;
	}

	public Double getRelacaoAguaGrao() {
		return relacaoAguaGrao;
	}

	public void setRelacaoAguaGrao(Double relacaoAguaGrao) {
		this.relacaoAguaGrao = relacaoAguaGrao;
	}

	public String getCorHexaDecimal(){

		String[] srm = new String[42];
		srm[0] = "#FFF4D4";
		srm[1] = "#FFE699";
		srm[2] = "#FFD878";
		srm[3] = "#FFCA5A";
		srm[4] = "#FFBF42";
		srm[5] = "#FBB123";
		srm[6] = "#F8A600";
		srm[7] = "#F39C00";
		srm[8] = "#EA8F00";
		srm[9] = "#E58500";
		srm[10] = "#DE7C00";
		srm[11] = "#D77200";
		srm[12] = "#CF6900";
		srm[13] = "#CB6200";
		srm[14] = "#C35900";
		srm[15] = "#BB5100";
		srm[16] = "#B54C00";
		srm[17] = "#B04500";
		srm[18] = "#A63E00";
		srm[19] = "#A13700";
		srm[20] = "#9B3200";
		srm[21] = "#952D00";
		srm[22] = "#8E2900";
		srm[23] = "#882300";
		srm[24] = "#CF6900";
		srm[25] = "#7B1A00";
		srm[26] = "#771900";
		srm[27] = "#701400";
		srm[28] = "#6A0E00";
		srm[29] = "#660D00";
		srm[30] = "#5E0B00";
		srm[31] = "#5A0A02";
		srm[32] = "#600903";
		srm[33] = "#520907";
		srm[34] = "#4C0505";
		srm[35] = "#470606";
		srm[36] = "#420607";
		srm[37] = "#3D0708";
		srm[38] = "#370607";
		srm[39] = "#2D0607";
		srm[40] = "#1F0506";
		srm[41] = "#000000";

		Double cor = getCor();
		if (cor > 41)
			cor = 41d;
		else if (cor < 0)
			cor = 0d;
		return srm[cor.intValue()];
	}
}
