package model;

public class Apartment{
    private int numberApartment;
    private int numberRoom;
    private int numberBath;
    private boolean balconyApartment;
    private double monthRent;
    private Person[] owner;
    private Person[] tenant;
    private final int TOTAL_OWNERS=1;
    private final int TOTAL_TENANT=1;
    public Apartment(int numberApartment, int numberRoom, int numberBath, boolean balconyApartment, double monthRent){
        this.numberApartment=numberApartment;
        this.numberRoom=numberRoom;
        this.numberBath=numberBath;
        this.balconyApartment=balconyApartment;
        this.monthRent=monthRent;
        this.owner=new Owner[TOTAL_OWNERS];
        this.tenant=new Tenant[TOTAL_TENANT];
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
    public Person[] getOwner() {
        return owner;
    }

    public void setOwner(Person[] owner) {
        this.owner = owner;
    }

    //--------------------------------------------------------

    public Person[] getTenant() {
        return tenant;
    }

    public void setTenant(Person[] tenant) {
        this.tenant = tenant;
    }
   

    //--------------------------------------------------------
    public String addOwner(Person newOwner){
        String msj="there is already a owner of the apartment";
        if(owner[0]==null){
            owner[0]=newOwner;
            msj="new owner added";
        }
        return msj;
    }

    public String addTenant(Person newTenant){
        String msj="there is already a tenant of the apartment";
        if(tenant[0]==null){
            tenant[0]=newTenant;
            msj="new tenant added";
        }
        return msj;
    }
    
}