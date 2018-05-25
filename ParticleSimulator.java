import java.awt.event.*;

public class ParticleSimulator {
    public static void main(String[] args){
        MyFrame frame = new MyFrame();

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
}
