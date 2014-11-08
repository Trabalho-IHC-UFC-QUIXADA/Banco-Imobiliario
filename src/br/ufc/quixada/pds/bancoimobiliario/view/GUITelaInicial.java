package br.ufc.quixada.pds.bancoimobiliario.view;

import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import br.ufc.quixada.pds.bancoimobiliario.view.sons.ControladorDeSons;


public class GUITelaInicial extends JFrame {
	private List<JTextField> nomesJogadores; 
	private List<JButton> tecnicos;
	private JButton bolaInicioJogo;
	private String[] nomesTecnicos = {"Pep Guardiola", "José Mourinho", "Jürgen Klopp", "Arsene Wenger", "Diego Simeone", "Carlo Ancelotti"};
	private static final String caminhoImagens = "/br/ufc/quixada/pds/bancoimobiliario/view/img/";
	private List<JButton> tecnicosDosJogadores;
	private List<JButton> botoesAlterar;
	private ControladorDeSons controladorDeSons;
	private JButton pararMusica;
	
	public GUITelaInicial(){
		this.tecnicos = new ArrayList<JButton>();
		this.nomesJogadores = new ArrayList<JTextField>();
		this.tecnicosDosJogadores = new ArrayList<JButton>();
		this.botoesAlterar = new ArrayList<JButton>();
	    this.setBounds(100, 0, 1150, 700);
	    initComponents();
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
	    this.setResizable(false);
	    
	    this.controladorDeSons = new ControladorDeSons("src/br/ufc/quixada/pds/bancoimobiliario/view/sons/hino.wav");
	    this.controladorDeSons.start();
	}
	
	public void initComponents(){
		JLabel background = new JLabel();
	    background.setIcon(new ImageIcon(GUITelaInicial.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/TelaInicialBackground.png")));
	    background.setBounds(0, 0, 1150, 700);
	    getContentPane().add(background);
	    Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	    
	    for(int i=0; i<6; i++){
	    	JButton tecnico = new JButton("");
	    	tecnico.setBackground(Color.WHITE);
	    	tecnico.setBounds(64+(i*181),150,117,150);
	    	tecnico.setToolTipText(this.nomesTecnicos[i]);
	    	
	    	String nomeImagem = this.nomesTecnicos[i].replaceAll("\\s","").toLowerCase();
			nomeImagem = Normalizer.normalize(nomeImagem, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			
			
			URL pathImagem = GUITelaInicial.class.getResource(caminhoImagens  + "tecnicos/" + nomeImagem  +".png");
			ImageIcon imageIcon = new ImageIcon(pathImagem);
			tecnico.setIcon(imageIcon);
			
			
			tecnico.setCursor(cursor);
			
	    	this.tecnicos.add(tecnico);
	    	background.add(tecnico);
	    	
	    	JLabel nomeTecnico = new JLabel(this.nomesTecnicos[i], SwingConstants.CENTER);
	    	nomeTecnico.setBounds(64+(i*181), 310, 117, 30);
	    	nomeTecnico.setForeground(Color.WHITE);
	    	background.add(nomeTecnico);
	    }
	    
	    JTextField nomeJogador1TxtField = new JTextField(null);
	    nomeJogador1TxtField.setBounds(40, 440, 169, 33);
	    background.add(nomeJogador1TxtField);
	    this.nomesJogadores.add(nomeJogador1TxtField);
	    nomeJogador1TxtField.setColumns(10);
	    
	    JButton jogador1Selecionado = new JButton("");
	    jogador1Selecionado.setBackground(Color.WHITE);
	    jogador1Selecionado.setBounds(40, 493, 117, 150);
	    this.tecnicosDosJogadores.add(jogador1Selecionado);
	    background.add(jogador1Selecionado);
	    
	    JLabel nomeJogador1Label = new JLabel("Nome jogador 1:");
	    nomeJogador1Label.setFont(new Font("Tahoma", Font.BOLD, 14));
	    nomeJogador1Label.setForeground(Color.WHITE);
	    nomeJogador1Label.setBounds(40, 413, 150, 20);
	    background.add(nomeJogador1Label);
	    
	    JButton jogador2Selecionado = new JButton("");
	    jogador2Selecionado.setBackground(Color.WHITE);
	    jogador2Selecionado.setBounds(993, 493, 117, 150);
	    this.tecnicosDosJogadores.add(jogador2Selecionado);
	    background.add(jogador2Selecionado);
	    
	    JTextField nomeJogador2TxtField = new JTextField(null);
	    nomeJogador2TxtField.setColumns(10);
	    nomeJogador2TxtField.setBounds(941, 440, 169, 33);
	    this.nomesJogadores.add(nomeJogador2TxtField);
	    background.add(nomeJogador2TxtField);
	    
	    JLabel nomeJogador2Label = new JLabel("Nome jogador 2:");
	    nomeJogador2Label.setFont(new Font("Tahoma", Font.BOLD, 14));
	    nomeJogador2Label.setForeground(Color.WHITE);
	    nomeJogador2Label.setBounds(978, 413, 150, 20);
	    background.add(nomeJogador2Label);
	    
	    JButton alterarJogador1 = new JButton("Alterar");
	    alterarJogador1.setBounds(40, 650, 117, 25);
	    this.botoesAlterar.add(alterarJogador1);
	    background.add(alterarJogador1);
	    
	    JButton alterarJogador2 = new JButton("Alterar");
	    alterarJogador2.setBounds(993, 650, 117, 25);
	    this.botoesAlterar.add(alterarJogador2);
	    background.add(alterarJogador2);
	    
	    JLabel iniciarOJogoLabel = new JLabel("Iniciar o Jogo");
	    iniciarOJogoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	    iniciarOJogoLabel.setBounds(530, 500, 150, 15);
	    background.add(iniciarOJogoLabel);
	    
	    bolaInicioJogo = new JButton();
	    bolaInicioJogo.setIcon(new ImageIcon(GUITelaInicial.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/Bola.png")));
	    bolaInicioJogo.setOpaque(false);
	    bolaInicioJogo.setContentAreaFilled(false);
	    bolaInicioJogo.setBorderPainted(false);
	    bolaInicioJogo.setBorder(null);
	    bolaInicioJogo.setBounds(543, 430, 70, 70);
	    bolaInicioJogo.setToolTipText("Clique para iniciar");
	    bolaInicioJogo.setCursor(cursor);
	    background.add(bolaInicioJogo);
	    
	    pararMusica = new JButton();
	    pararMusica.setIcon(new ImageIcon(GUITelaInicial.class.getResource("/br/ufc/quixada/pds/bancoimobiliario/view/img/sons/music_on.png")));
	    pararMusica.setOpaque(false);
	    pararMusica.setContentAreaFilled(false);
	    pararMusica.setBorderPainted(false);
	    pararMusica.setBorder(null);
	    pararMusica.setBounds(1100, 25, 25, 25);
	    pararMusica.setToolTipText("Clique para iniciar");
	    pararMusica.setCursor(cursor);
	    background.add(pararMusica);
	    
	    
	}
	
	public List<JButton> getTecnicos(){
		return this.tecnicos;
	}
	
	public JButton getBotaoInicial(){
		return this.bolaInicioJogo;
	}
	
	public String[] getNomesTecnicos(){
		return this.nomesTecnicos;
	}
	
	public List<JTextField> getTextFielNomeJogadores(){
		return this.nomesJogadores;
	}
	
	public List<JButton> getTecnicosDosJogadores(){
		return this.tecnicosDosJogadores;
	}
	
	public  List<JButton> getBotoesAlterar(){
		return this.botoesAlterar;
	}
	
	public ControladorDeSons getControladorDeSom(){
		return this.controladorDeSons;
	}
	
	public JButton getPararMusica(){
		return this.pararMusica;
	}
	
	public boolean musicaAtiva(){
		return this.controladorDeSons.isAlive();
	}
	
	public void pararMusica(){
		this.controladorDeSons.stop();
	}
	
	public void reiniciarMusica(){
		this.controladorDeSons = new ControladorDeSons("src/br/ufc/quixada/pds/bancoimobiliario/view/sons/hino.wav");
		this.controladorDeSons.start();
	}
}
