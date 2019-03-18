import java.util.LinkedList;

public class SolarSystem {
    public final static double G = 6.674E-11;
    public final static double AU = 1.49598E11;

    public SolarSystem(){}

    public LinkedList<CelestialBody> bodies = new LinkedList();
    {
        //used Start=2019-03-16 for the data below. For x, y, z the units are kilometers and for vX, vY, vZ the units are km/s
        this.bodies.add(new CelestialBody("Sun", 1.989E30, 0,0,0,0,0,0));
        this.bodies.add(new CelestialBody("Earth", 5.972E24, -1.481794341409843E+08,-1.335082147407329E+07,-1.144766017915681E+02,-3.147119588962150E+00,2.977667999911005E+01,2.219335592474891E-04));
        //this.bodies.add(new CelestialBody("Rocket", 27500, -1.481794341409843E+08,-1.335082147407329E+07,-1.144766017915681E+02,-2.462334537373544E+00,3.972871397530023E+01,2.995925515083542E-04));
        this.bodies.add(new CelestialBody("Mercury", 3.30104E23, -5.722547047338255E+07,-2.241363602483821E+06,5.432870624994821E+06,-1.203839952520884E+01,4.658319828975102E+01,-2.702104307038759E+00));
        this.bodies.add(new CelestialBody("Venus", 4.86732E24, -2.048993939199266E+07,1.066998524721130E+08,-2.816282594203725E+05,3.415769541876617E+01,6.744265470063873E+00,-2.063699531213292E+00));
        this.bodies.add(new CelestialBody("Mars", 6.41693E23, 3.522726901716241E+07,-2.288494318618847E+08,3.930826132489771E+06,-2.303192754791928E+01,-5.745391418134417E+00,6.855203858240730E-01));
        this.bodies.add(new CelestialBody("Jupiter", 1.89813E27, -2.420589504714857E+08,7.592885440717547E+08,8.569796475571454E+06,1.230262697471333E+01 ,3.355092687890090E+00,-2.613182726816594E-01));
        this.bodies.add(new CelestialBody("Saturn", 5.68319E26, 3.501597713503500E+08,1.463105874755335E+09,1.149590126583952E+07,8.877005882528771E+00 ,-2.216113880355679E+00,-3.917235712943424E-01));
        this.bodies.add(new CelestialBody("Uranus", 8.68103E25, 2.522606141537412E+09,-1.567434116652863E+09,-2.684610808868790E+07,3.632077578548763E+00 ,-5.463472289189403E+00,6.711898140461603E-02));
        this.bodies.add(new CelestialBody("Neptune", 1.0241E26, 4.344116770585548E+09,1.086414218049771E+09,-7.775418062412483E+07,1.295822303806585E+00 ,-5.304061497251910E+00,-1.386683896897232E-01));
    }

    public void force(CelestialBody body){
        Vector totalForce = new Vector(0,0,0);

        for(int i=0; i < bodies.size(); i++) {
            if(body!= bodies.get(i)) {
                //Celestial body to compare with
                CelestialBody body2 = bodies.get(i);
                CelestialBody temp = body2;
                CelestialBody temp2 = new CelestialBody(temp.getName(),temp.getMass(),temp.getLocation().getX(),temp.getLocation().getY(),temp.getLocation().getZ(),temp.getVelocity().getX(),temp.getVelocity().getY(),temp.getVelocity().getZ());
                Vector vectorAB = temp2.getLocation().subtract(body.getLocation());
                double r = vectorAB.getLength();
                Vector normalizedAB = vectorAB.normalize();
                //The formula for gravitational forces
                if(r==0){
                    r = 1;
                }
                double f = G*(body.getMass() * body2.getMass()) / (r * r);
                totalForce = totalForce.add(normalizedAB.multiply(f));

            }
        }
        //body.printVelocity();
        body.acceleration(totalForce.divide(body.getMass()));

    }

    public void update(){
        for(int i=0; i < bodies.size(); i++) {

            Vector change = bodies.get(i).getVelocity();
            Vector temp = new Vector(change.getX() * 60,change.getY() * 60,change.getZ()* 60);
            bodies.get(i).getLocation().add(temp);
        }
    }
}
