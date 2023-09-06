// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.lang.Math;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    double m;
    double c;
    double t;
    double b;
    double g;

    public Main() {
        m = c = t = b = g = 0;
    }

    public Main(double m, double c, double t, double b, double g) {
        this.m = m;
        this.c = c;
        this.t = t;
        this.b = b;
        this.g = g;
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

    public double сalc_f() {
        return Math.cbrt(m * t * g * t + Math.abs(c * Math.sin(t)));
    }

    public double сalc_z() {
        return m * Math.cos(b *t * Math.sin(t)) + c;
    }

    public void CurDate() {
        System.out.println(java.time.LocalDateTime.now());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setData(2, -1, 1.2, 0.7, 1.9);
        main.getData();
        System.out.println("f: " + main.сalc_f());
        System.out.println("z: " + main.сalc_z());
        main.CurDate();
    }
}