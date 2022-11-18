
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

    public void ambilSaldo(int nominal) {
        // ...
    }

    public void dataSaldo() {
        System.out.println("Saldo           : " + saldo);
    }
}
