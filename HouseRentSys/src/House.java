public class House {
    private String ownerName;
    private int houseID;
    private String phoneNumber;
    private String address;
    private double rentFee;
    private String state;

    public int getHouseID() {
        return houseID;
    }

    public void setHouseID(int houseID) {
        this.houseID = houseID;
    }

    public House(String ownerName, int houseID, String phoneNumber, String address, double rentFee, String state) {
        this.ownerName = ownerName;
        this.houseID = houseID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rentFee = rentFee;
        this.state = state;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRentFee() {
        return rentFee;
    }

    public void setRentFee(double rentFee) {
        this.rentFee = rentFee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    @Override
    public String toString() {
        return  houseID +
                "\t\t" + ownerName +
                "\t" + phoneNumber +
                "\t\t" + address +
                "\t" + rentFee +
                "\t" + state ;
    }
}
