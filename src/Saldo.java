
// Class Entitas
public class Saldo {
    int saldo = 0;

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
