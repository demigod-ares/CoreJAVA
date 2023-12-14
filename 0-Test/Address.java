public class Address implements Comparable<Address>{
    private String addressLine1;
    private int pin;

    public Address(String addressLine1, int pin){
        this.addressLine1 = addressLine1;
        this.pin = pin;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public int getPin() {
        return pin;
    }

    @Override
    public int compareTo(Address o) {
        return this.getPin() - o.getPin();
    }
}
