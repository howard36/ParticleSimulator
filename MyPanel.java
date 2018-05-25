import java.awt.*;
import java.util.*;
import java.awt.image.*;

public class MyPanel extends Panel {
    int numParticles = 20;
    ArrayList<Particle> particles = new ArrayList<Particle>();
    double mx, my;
    long period = 30;
    long delay = 100;
    Timer timer = new Timer();
    BufferedImage osi;
    Graphics osg;
    Dimension d;

    // cannot be a constructor, because it must be called after frame.setVisible, in order to use getSize properly
    public void init(){
        d = getSize();
        mx = d.width/2; my = d.height/2;
        setBackground(Color.BLACK);
        for (int i = 0; i<numParticles; i++){
            particles.add(new Particle(d));
        }
        TimerTask task = new TimerTask(){
            public void run(){
                for (Particle p : particles){
                    p.move(mx, my, period);
                }
                repaint();
            }
        };
        timer.scheduleAtFixedRate(task, delay, period);
    }

    public void paint(Graphics g){
        d = getSize();
        osi = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
        osg = osi.getGraphics();
        update(g);
    }

    public void update(Graphics g){
        osg.setColor(Color.BLACK);
        // osg.fillRect(0, 0, d.width, d.height); // comment and make numParticles < 10 to see different cool effects
        for (Particle p : particles){
            p.display(osg);
        }
        g.drawImage(osi, 0, 0, this);
    }
}
