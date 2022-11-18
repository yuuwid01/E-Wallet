import java.util.ArrayList;

// Class Core (Inti)
public class EWallet {
    static ArrayList<User> akunTerdaftar = new ArrayList<>();

    public static void initialUser() {
        User user = new User("Test", "user", "1", "081", "123");

        Auth.register(user);

    }

    public static int cekSaldo(User user) {
        return user.dompet.saldo.saldo;
    }


}