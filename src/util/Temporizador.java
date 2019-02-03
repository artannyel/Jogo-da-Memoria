package util;

public class Temporizador implements Runnable{
    private double tempo;
    private String nome;
    public Temporizador(double tempo, String nome){
        this.tempo = tempo;
        this.nome = nome;
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
       System.out.println(nome+ " em execurção");
        try {
            Thread.sleep((int)tempo*1000);
        } catch (Exception e) {
        }
        System.out.println(nome+" finalizada");
                    
                
    }
}
