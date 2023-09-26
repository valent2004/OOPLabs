// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private double m;
    private double c;
    private double t;
    private double b;
    private double g;

    public Main() {
        m = c = t = b = g = 0.0;
    }

    public Main(double m, double c, double t, double b, double g) {
        setData(m, c, t, b, g);
    }

    public void setData(double m, double c, double t, double b, double g) {
        this.m = m;
        this.c = c;
        this.t = t;
        this.b = b;
        this.g = g;
    }

    public void getData() {
        System.out.println("Data values:");
        System.out.println("m: " + m);
        System.out.println("c: " + c);
        System.out.println("t: " + t);
        System.out.println("b: " + b);
        System.out.println("g: " + g);
    }

    public double calcF() {
        return Math.cbrt(m * t * g * t + Math.abs(c * Math.sin(t)));
    }

    public double calcZ() {
        return m * Math.cos(b * t * Math.sin(t)) + c;
    }

    public void CurDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.h.m.s.S - D");
        System.out.println(dateFormat.format(date));
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setData(2, -1, 1.2, 0.7, 1.9);
        main.getData();
        System.out.println("f: " + main.calcF());
        System.out.println("z: " + main.calcZ());
        main.CurDate();
    }
}