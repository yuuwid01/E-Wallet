public class App {
    public static void main(String[] args) {
        Storage.setInitialItem();
        EWallet.initialUser();

        new LoginPage();
    }
}
