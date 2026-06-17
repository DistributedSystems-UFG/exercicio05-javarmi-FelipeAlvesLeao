package example.hello;

import java.rmi.Naming;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");

        String host = (args.length < 1) ? null : args[0];
        try {
            Hello helloStub = (Hello) Naming.lookup("rmi://" + host + "/MyHello");
            System.out.println("Found Hello server");

            String response = helloStub.sayHello();
            System.out.println("sayHello: " + response);

            System.out.println("soma(100, 1000): " + helloStub.soma(100, 1000));
            System.out.println("subtrai(500, 200): " + helloStub.subtrai(500, 200));
            System.out.println("multiplica(7, 8): " + helloStub.multiplica(7, 8));
            System.out.println("toUpperCase(\"rmi em java\"): " + helloStub.toUpperCase("rmi em java"));

            Calculadora calcStub = (Calculadora) Naming.lookup("rmi://" + host + "/MyCalculadora");
            System.out.println("Found Calculadora server");

            System.out.println("fatorial(10): " + calcStub.fatorial(10));
            System.out.println("potencia(2, 10): " + calcStub.potencia(2, 10));
            System.out.println("ehPrimo(17): " + calcStub.ehPrimo(17));
            System.out.println("ehPrimo(18): " + calcStub.ehPrimo(18));

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
