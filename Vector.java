public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;

    }
    public double getX(){return x;}
    public double getY(){return y;}
    public double getZ(){return z;}
    public double getLength(){
        return Math.sqrt(x*x + y*y + z*z);
    }

    public Vector subtract(Vector v1){
        x = x - v1.x;
        y = y - v1.y;
        z = z - v1.z;
        return this;
    }
    public Vector add(Vector v1){
        x = x + v1.x;
        y = y + v1.y;
        z = z + v1.z;
        return this;
    }
    public Vector multiply(double amount){
        x = x * amount;
        y = y * amount;
        z = z * amount;
        return this;
    }
    public Vector divide(double amount){
        if(amount != 0) {
            x = x / amount;
            y = y / amount;
            z = z / amount;
        }
        return this;
    }
    public Vector normalize(){
        return multiply(1.0/getLength());
    }
}
