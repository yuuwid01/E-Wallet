import entity.User;

public class Auth {
    private static User userLogged = null;

    public static boolean login(String username, String password) {
        for (User user : EWallet.getAkunTerdaftar()) {
            if ((user.getUsername().equals(username)) && (user.getPassword().equals(password))) {
                userLogged = user;
                return true;
            }
        }
        return false;
    }

    public static boolean register(User akunBaru) {
        for (User akun : EWallet.getAkunTerdaftar()) {
            if ((akun.getUsername().equals(akunBaru.getUsername()))
                    || (akun.getNoTelp().equals(akunBaru.getNoTelp()))) {
                return false;
            }
        }

        EWallet.getAkunTerdaftar().add(akunBaru);
        return true;
    }

    public static boolean verifPin(String pin) {
        return userLogged.getPin().equals(pin);
    }

    public static void logout() {
        userLogged = null;
    }

    public static User getUserLogged() {
        return userLogged;
    }

}
