package model;

public class Apartment{
    private int numberApartment;
    private int numberRoom;
    private int numberBath;
    private boolean balconyApartment;
    private double monthRent;
    private Owner[] owner;

    public Apartment(int numberApartment, int numberRoom, int numberBath, boolean balconyApartment, double monthRent){
        this.numberApartment=numberApartment;
        this.numberRoom=numberRoom;
        this.numberBath=numberBath;
        this.balconyApartment=balconyApartment;
        this.monthRent=monthRent;
        this.owner=new Owner[0];
    }

    public int getNumberApartment() {
        return numberApartment;
    }

    public void setNumberApartment(int numberApartment) {
        this.numberApartment = numberApartment;
    }

    //--------------------------------------------------------

    public int getNumberRoom() {
        return numberRoom;
    }
    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    //--------------------------------------------------------

    public int getNumberBath() {
        return numberBath;
    }

    public void setNumberBath(int numberBath) {
        this.numberBath = numberBath;
    }

    //--------------------------------------------------------

    public double getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(double monthRent) {
        this.monthRent = monthRent;
    }

    //--------------------------------------------------------

    public boolean getBalconyApartment(){
        return balconyApartment;
    }

    public void setBalconyApartment(boolean balconyApartment) {
        this.balconyApartment = balconyApartment;
    }

    //--------------------------------------------------------
    public String addOwner(Owner newOwner){
        String msj="there is already a owner of the apartment";
        if(owner[0]==null){
            owner[0]=newOwner;
            msj="new owner added";
        }
        return msj;
    }
    
}