package br.ufc.quixada.pds.bancoimobiliario.model;

import br.ufc.quixada.pds.bancoimobiliario.enumeration.ConfiguracoesEnum;
import br.ufc.quixada.pds.bancoimobiliario.exception.MontadorTabuleiroException;


public class TabuleiroBuilderConcrete implements TabuleiroBuilder{

	private Tabuleiro tabuleiro;
	private boolean first,last;
	private int qtdCasas;
	
	
	public TabuleiroBuilderConcrete(){
		this.tabuleiro = new Tabuleiro();
		this.first = false;
		this.last = false;
		this.qtdCasas = 0;
	}
	
	@Override
	public void montarPontoPartida(PontoDePartida pontoDePartida) throws MontadorTabuleiroException {
		if(first = false){
			tabuleiro.getLogradouros().add(pontoDePartida);
			first = true;
			this.qtdCasas++;
		}else{
			throw new MontadorTabuleiroException("Ponto de partida j� adicionado");
		}
	}

	@Override
	public void montarCasaIntermediaria(Logradouro logradouro) throws MontadorTabuleiroException {
		int casasRestantes = ConfiguracoesEnum.NUMERO_CASAS.getValor() - qtdCasas;
		if(first && (casasRestantes > 1)){
			tabuleiro.getLogradouros().add(logradouro);
			this.qtdCasas++;
		}else{
			String mensagem = "";
			if(first == false){
				mensagem = "Necess�rio adicionar ponto inicial";
			}else{
				mensagem = "J� foram adicionadas muitas casas, adicione a �ltima";
			}
			throw new MontadorTabuleiroException(mensagem);
		}
	}

	@Override
	public void montarUltimaCasa(Logradouro logradouro) throws MontadorTabuleiroException {
		int casasRestantes = ConfiguracoesEnum.NUMERO_CASAS.getValor() - qtdCasas;
		if(casasRestantes > 1){
			tabuleiro.getLogradouros().add(logradouro);
			this.qtdCasas++;
			last = true;
		}else{
			throw new MontadorTabuleiroException("Faltam adicionar " + casasRestantes +" casas");
		}
		
	}
	
	@Override
	public Tabuleiro getTabuleiro() throws MontadorTabuleiroException{
		if(first && last){
			return this.tabuleiro;
		}else{
			throw new MontadorTabuleiroException("Tabuleiro n�o montado");
		}
	}

}
