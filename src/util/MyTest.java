package util;

public class MyTest {
    public MyTest(){
        System.out.println("Constructor");
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try { Thread.sleep(3000); } catch (Exception e) {}
                System.out.println("run");
            }
        });
        //run();
        
    }
   
     public void run(){
        try { Thread.sleep(3000); } catch (Exception e) {} 
        System.out.println("run");
    }
}

