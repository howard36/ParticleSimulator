import java.util.*;
import java.awt.*;

public class Particle{
    int w, h;
    double px, py;
    double vx, vy;
    double r = 1;
    double G = 200000; // a gravitational constant
    double fric = 0.02;
    double maxSpeed = 100000;
    double speed;

    public Particle(Dimension d){
        w = d.width; h = d.height;
        px = Math.random()*w; py = Math.random()*h;
        vx = (Math.random()-0.5)*500; vy = (Math.random()-0.5)*500;
        // System.out.println("Starting position is ("+px+", "+py+")");
        // System.out.println("Starting velocity is ("+vx+", "+vy+")");
        // vx = vy = fric = 0;
    }

    public void move(double mx, double my, double t){
        t /= 1000;
        double r2 = (px-mx)*(px-mx)+(py-my)*(py-my); // square of distance to mouse
        vx = vx*(1-fric) + (mx-px)*G/r2*t;
        vy = vy*(1-fric) + (my-py)*G/r2*t;
        px += vx*t;
        py += vy*t;
        px %= 2*w;
        py %= 2*h;
        if (px < 0){
            px = -px;
            vx = -vx;
        }
        else if (px > w){
            px = 2*w-px;
            vx = -vx;
        }
        if (py < 0){
            py = -py;
            vy = -vy;
        }
        else if (py > h){
            py = 2*h-py;
            vy = -vy;
        }
        speed = Math.sqrt(vx*vx+vy*vy);
        if (speed > maxSpeed){
            // System.out.println("Exceeded max speed");
            vx *= speed/maxSpeed;
            vy *= speed/maxSpeed;
            speed = maxSpeed;
        }
    }

    public void display(Graphics g){
        g.setColor(Color.getHSBColor((float)Math.pow(speed/maxSpeed, 0.29), 1, 1f));
        // g.setColor(Color.YELLOW);
        g.fillOval((int)(px-r), (int)(py-r), (int)(2*r), (int)(2*r));
    }
}
