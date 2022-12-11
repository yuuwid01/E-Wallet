package entity;

// Class Entitas
public class TopUp extends Transaksi {

    public TopUp(int nominalTopup) {
        super("Top Up", nominalTopup, nominalTopup);
    }

}
