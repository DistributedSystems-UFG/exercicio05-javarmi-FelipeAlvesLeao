package example.hello;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculadoraImplem extends UnicastRemoteObject implements Calculadora {

    public CalculadoraImplem(int port) throws RemoteException {
        super(port);
    }

    public long fatorial(int n) throws RemoteException {
        if (n < 0) throw new RemoteException("Fatorial indefinido para negativos");
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public double potencia(double base, double expoente) throws RemoteException {
        return Math.pow(base, expoente);
    }

    public boolean ehPrimo(int n) throws RemoteException {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
