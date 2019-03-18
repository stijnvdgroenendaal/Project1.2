import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    //---
    private JFrame frame = new JFrame();
    private SolarSystem solarSystem = new SolarSystem();

    public Test() {
        start();
    }

    public void start() {

        frame.setSize(1280, 1280);
        frame.setContentPane(new UniFrame(this.solarSystem));
        frame.setVisible(true);

        while (true) {
            for(int j = 0; j<60*24*7; j++) {
                for (int i = 0; i < solarSystem.bodies.size(); i++) {
                    if (solarSystem.bodies.get(i) != solarSystem.bodies.get(0)) {
                        solarSystem.force(solarSystem.bodies.get(i));
                    }
                }
                solarSystem.update();
            }
            frame.getContentPane().repaint();
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public class UniFrame extends JPanel {

        private SolarSystem solarSystem;

        public UniFrame(SolarSystem universe) {
            this.solarSystem = universe;
        }

        boolean X_Y_PLANE = false;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            //--- background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 1280, 1280);


            for (CelestialBody body : solarSystem.bodies) {
                g.setColor(Color.WHITE);
                int x = (int) (((body.getLocation().getX() / SolarSystem.AU) *20) + this.getSize().getWidth() / 2);
                int y = (int) (((body.getLocation().getY() / SolarSystem.AU) *20) + this.getSize().getHeight() / 2);

                g.drawString(body.getName(), x, y);
                g.drawOval(x - 5, y - 5, 10, 10);

            }
        }
    }
}