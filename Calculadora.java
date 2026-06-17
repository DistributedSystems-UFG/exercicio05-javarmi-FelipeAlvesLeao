package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
    long fatorial(int n) throws RemoteException;
    double potencia(double base, double expoente) throws RemoteException;
    boolean ehPrimo(int n) throws RemoteException;
}
