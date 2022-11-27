
// Class Entitas
public class Saldo {
    int saldo = 0;

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

}
