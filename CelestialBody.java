

public class CelestialBody {
    private String name;
    private double mass;
    private Vector location;
    private Vector velocity;

    public CelestialBody(String name, double mass, double x, double y, double z, double vX, double vY, double vZ){
        this.name = name;
        this.mass = mass;
        this.location = new Vector(x*1000, y*1000, z*1000);
        this.velocity = new Vector(vX*1000, vY*1000, vZ*1000);
        //multiply by 1000 to go from kilometers to meters

    }

    public String getName(){
        return name;
    }
    public double getMass(){
        return mass;
    }
    public Vector getLocation(){
        return location;
    }
    public Vector getVelocity(){
        return velocity;
    }
    public void printVelocity(){
        System.out.println(getVelocity().getX() + " " + getVelocity().getY()+ " " + getVelocity().getZ());
    }
    public void acceleration(Vector f){
        velocity = velocity.add(f.multiply(60));
    }

}
