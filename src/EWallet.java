import java.util.ArrayList;

// Class Core (Inti)
public class EWallet {
    private static ArrayList<User> akunTerdaftar = new ArrayList<>();

    public static void initialUser() {
        User user = new User("Test", "user", "1", "081", "123");

        Auth.register(user);

    }

    public static int cekSaldo(User user) {
        return user.dompet.saldo.saldo;
    }

    public static void topUp(User user, TopUp transaksi) {
        user.dompet.tambahTransaksi(transaksi);
        user.dompet.saldo.tambahSaldo(transaksi.nominalHarga);
    }

    public static boolean beliPulsa(User user, Transaksi transaksi) {
        boolean status = user.dompet.saldo.ambilSaldo(transaksi.nominalHarga);
        if (status) {
            user.dompet.tambahTransaksi(transaksi);
        }
        return status;
    }

    public static ArrayList<User> getAkunTerdaftar() {
        return akunTerdaftar;
    }

}