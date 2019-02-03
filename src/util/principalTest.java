package util;

import javax.swing.SwingUtilities;

public class principalTest {
    public static void main(String[] args) {
        /*
    Runnable doHelloWorld = new Runnable () {
     public void run () {
         System.out.println ("Hello World on" + Thread.currentThread ());
     }
 };

 SwingUtilities.invokeLater (doHelloWorld);
 System.out.println ("Isso pode ser exibido antes da outra mensagem.");
       */
        
         final Runnable doHelloWorld = new Runnable () {
     public void run () {
         System.out.println ("Hello World on " + Thread.currentThread ());
     }
 };

 Thread  appThread = new Thread () {
     public void run () {
         try {
             SwingUtilities.invokeLater (doHelloWorld);
         }
         catch (Exception e) {
             e.printStackTrace ();
         }
         System.out.println ("Concluído em " + Thread.currentThread ());
     }
 };
 appThread.start ();
    }
    
}
