package br.ufc.quixada.pds.bancoimobiliario.model;

public class AcaoAvancaPosicao implements AcaoLugarEspecial{

	private int quantidadeDePosicoes;
	
	public AcaoAvancaPosicao(int quantidadeDePosicoes) {
		this.quantidadeDePosicoes = quantidadeDePosicoes;
	}
	@Override
	public void executar(Jogador jogador) throws ValorInvalidoException{
		jogador.avancarPosicaoJogador(quantidadeDePosicoes);
	}
}
