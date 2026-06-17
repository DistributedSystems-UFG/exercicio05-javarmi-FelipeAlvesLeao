package example.hello;

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {

    public Server() {}

    public static void main(String args[]) {
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Registry registry = LocateRegistry.getRegistry("localhost");

            HelloImplem helloObj = new HelloImplem(5678);
            Naming.rebind("MyHello", helloObj);

            CalculadoraImplem calcObj = new CalculadoraImplem(5679);
            Naming.rebind("MyCalculadora", calcObj);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
