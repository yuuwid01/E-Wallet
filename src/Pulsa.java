
// Class Entitas
public class Pulsa {
    String nominalPulsa;
    String hargaPulsa;

    public Pulsa(String nominalPulsa, String hargaPulsa) {
        this.nominalPulsa = nominalPulsa;
        this.hargaPulsa = hargaPulsa;
    }

    public void dataPulsa() {
        System.out.println("Nominal Pulsa   : " + nominalPulsa);
        System.out.println("Harga Pulsa     : " + hargaPulsa);
    }
}