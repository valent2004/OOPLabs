// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.lang.Math;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public double m;
    public double c;
    public double t;
    public double b;
    public double g;

    public Main()
    {
        m = c = t = b = g = 0;
    }

    public Main(double m, double c, double t, double b, double g)
    {
        this.m = m;
        this.c = c;
        this.t = t;
        this.b = b;
        this.g = g;
    }

    public void setData(double m, double c, double t, double b, double g)
    {
        this.m = m;
        this.c = c;
        this.t = t;
        this.b = b;
        this.g = g;
    }

    public void getData()
    {
        System.out.println("Data values:");
        System.out.println("m: " + m);
        System.out.println("c: " + c);
        System.out.println("t: " + t);
        System.out.println("b: " + b);
        System.out.println("g: " + g);
    }

    public double multi(double a, double b)
    {
        return a * b;
    }

    public double abs(double mod)
    {
        if(mod < 0){return -1 * mod;}
        return mod;
    }

    public double f(double a, double b, double c)
    {
        return Math.cbrt(a + abs(multi(b, Math.sin(c))));
    }

    public double z(double a, double b, double c)
    {
        return multi(a, Math.cos(b)) + c;
    }

    public void CurDate() {System.out.println(java.time.LocalDateTime.now()); }

    public static void main(String[] args) {
        Main main = new Main();
        main.setData(2, -1, 1.2, 0.7, 1.9);
        main.getData();
        System.out.println("f: " + main.f(main.multi(main.m, main.multi(main.t, main.multi(main.g, main.t))), main.c, main.t));
        System.out.println("z: " + main.z(main.m, main.multi(main.b, main.multi(main.t, Math.sin(main.t))), main.c));
        main.CurDate();
    }
}