import java.awt.*;
import java.util.*;
import java.awt.image.*;
import java.awt.event.*;

public class MyPanel extends Panel implements MouseMotionListener, MouseListener {
    int numParticles = 10000;
    ArrayList<Particle> particles = new ArrayList<Particle>();
    double mx, my;
    long period = 10;
    long delay = 100;
    Timer timer = new Timer();
    BufferedImage osi;
    Graphics osg;
    Dimension d;

    public MyPanel(){
        addMouseMotionListener(this);
        addMouseListener(this);
    }

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
        osg.fillRect(0, 0, d.width, d.height); // comment and make numParticles < 10 to see different cool effects
        for (Particle p : particles){
            p.display(osg);
        }
        g.drawImage(osi, 0, 0, this);
    }

    // MouseMotionListener
    public void mouseDragged(MouseEvent e){
        mx = e.getX();
        my = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e){}

    // MouseListener
    public void mousePressed(MouseEvent e){
        mx = e.getX();
        my = e.getY();
        repaint();
    }

    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

}
