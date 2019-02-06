package util;

import javax.swing.ImageIcon;

public class Jogador {
	private final String nomeJogador;
	private final ImageIcon imagemJogador;
        private boolean minhaVez;
	private int pontuacaoJogador;
        
        /**
         * Criar um novo jogador com um nome e uma imagem
         * @param nome
         * @param imagem 
         * @param vez
         */
	public Jogador(String nome, ImageIcon imagem, boolean vez){
            this.nomeJogador = nome;
            this.imagemJogador = imagem;
            this.pontuacaoJogador = 0;
            this.minhaVez = vez;
        }
        
        /**
         * Criar um novo jogador com um nome
         * @param nome 
         */
        public Jogador(String nome, boolean vez){
            this.imagemJogador = null;
            this.nomeJogador = nome;
            this.pontuacaoJogador = 0;
            this.minhaVez = vez;
        }
        public Jogador(String nome, int pontos){
            this.imagemJogador = null;
            this.nomeJogador = nome;
        }
        
        /**
         * retorna uma String contendo o nome dojogador
         * @return String
         */
	public String getNomeJogador() {
		return nomeJogador;
	}
        
        /**
         * retorna a pontuação do jogador
         * @return  int
         */
	public int getPontuacaoJogador() {
            return pontuacaoJogador;
	}
        
        /**
         * atualiza a pontuação do jogador, tendo como paramentro os pontos feitos
         */
	public void ganhaPontos() {
            this.pontuacaoJogador += 3;
	}
        
        public void perdePontos(){
            //this.pontuacaoJogador -=1;
        }
	
        /**
         * Devolve a imagem do jogador
         * @return ImageIcon
         */
	public ImageIcon getImagemJogador() {
            return imagemJogador;
        }
        
        /**
         * Retorna um boolean indicando se é a vez do jogador
         * @return minhaVez
         */
        public boolean isMinhaVez() {
            return minhaVez;
        }

        /**
         * atualiza a vez do jogador
         * @param minhaVez 
         */
        public void setMinhaVez(boolean minhaVez) {
            this.minhaVez = minhaVez;
        }
        
}
