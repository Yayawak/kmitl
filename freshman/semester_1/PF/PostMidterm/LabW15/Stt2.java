package LabW15;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Stt2 {
    public static void main(String[] args) {
        Stt stt = new Stt();
        // stt.main(args);
        // Stt.StaticM();
        // Stt.to3String();
        // Stt.
        // stt.NormalP();

        Car[] cars = new Car[200];

        // Car.describeAllData();

        for (int i = 50; i < 100; i += 10)
        {
            Car c = new Car();
            c.addSpeed(i);

            cars[i] = c;

            // c
        }
    }
}
