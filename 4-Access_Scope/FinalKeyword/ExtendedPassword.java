package FinalInitializer;

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    // @Override // This method shows password of Child class
    // public void storePassword() { // if it was not final, it would have been overridden
    //     System.out.println("Saving password as " + this.decryptedPassword);
    // }
}
