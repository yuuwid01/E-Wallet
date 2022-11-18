public class Auth {
    static User userLogged = null;

    public static boolean login(String username, String password) {
        for (User user : EWallet.akunTerdaftar) {
            if ((user.username.equals(username)) && (user.password.equals(password))) {
                userLogged = user;
                return true;
            }
        }
        return false;
    }

    public static boolean register(User akunBaru) {
        for (User akun : EWallet.akunTerdaftar) {
            if ((akun.username.equals(akunBaru.username))
                    || (akun.noTelp.equals(akunBaru.noTelp))) {
                return false;
            }
        }

        EWallet.akunTerdaftar.add(akunBaru);
        return true;
    }

    public static boolean verifPin(String pin) {
        return userLogged.pin.equals(pin);
    }

    public static void logout() {
        userLogged = null;
    }

}
