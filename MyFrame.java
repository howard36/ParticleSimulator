import java.awt.*;

public class MyFrame extends Frame {
    MyPanel panel = new MyPanel();

    public MyFrame() {
        add(panel);
        setSize(1500, 1100);
        setLocation(0, 0);
        setTitle("Particle Simulator");
        setResizable(true);
        setVisible(true);
        panel.init();
    }
}
