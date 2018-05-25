import java.awt.*;

public class MyFrame extends Frame {
    MyPanel panel = new MyPanel();

    public MyFrame() {
        add(panel);
        setSize(1500, 1000);
        setLocation(50, 50);
        setTitle("Particle Simulator");
        setResizable(true);
        setVisible(true);
        panel.init();
    }
}
