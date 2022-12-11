package entity;

// Class Entitas
public class Saldo {
    private int saldo = 0;

    public Saldo() {
    }

    public Saldo(int saldo) {
        this.saldo = saldo;
    }

    public void tambahSaldo(int nominal) {
        saldo += nominal;
    }

    public boolean ambilSaldo(int nominal) {
        if (saldo >= nominal) {
            saldo -= nominal;
            return true;
        }
        return false;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
