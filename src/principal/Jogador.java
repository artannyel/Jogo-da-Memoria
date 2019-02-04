package principal;

import java.io.File;

import javax.swing.ImageIcon;

public class Jogador {
	private String nomeJogador;
	private int pontuacaoJogador = 0;
	private ImageIcon imagemJogador;
	private String urlImagem = new File("").getAbsolutePath();
	
	public Jogador(String nome) {
		this.nomeJogador = nome;
		this.imagemJogador = new ImageIcon(urlImagem+"\\src\\imagens\\padrao\\jogador.png"); 
	}
	
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public int getPontuacaoJogador() {
		return pontuacaoJogador;
	}
	public void setPontuacaoJogador(int pontuacaoJogador) {
		this.pontuacaoJogador += pontuacaoJogador;
	}
	
	
	
}
