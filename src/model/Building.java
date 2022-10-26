package model;

public class Building{
    private String nameBuilding;
    private int apartmentNumberBuilding;
    private String adressBuilding;
    private Apartment[] apartments;

    public Building(String nameBuilding, int apartmentNumberBuilding, String adressBuilding){
        this.nameBuilding=nameBuilding;
        this.apartmentNumberBuilding=apartmentNumberBuilding;
        this.adressBuilding=adressBuilding;
        this.apartments=new Apartment[apartmentNumberBuilding];
    }

    public String getNameBuilding() {
        return nameBuilding;
    }

    public void setAdressBuilding(String adressBuilding) {
        this.adressBuilding = adressBuilding;
    }

    //--------------------------------------------------------

    public int getapartmentNumberBuilding() {
        return apartmentNumberBuilding;
    }

    public void setApartmentNumberBuilding(int apartmentNumberBuilding) {
        this.apartmentNumberBuilding = apartmentNumberBuilding;
    }

    //--------------------------------------------------------

    public String getAdressBuilding() {
        return adressBuilding;
    }

    public void setNameBuilding(String nameBuilding) {
        this.nameBuilding = nameBuilding;
    }

    //--------------------------------------------------------

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }

    //--------------------------------------------------------

    public String addAparment(Apartment newApartment){
        String msj="max capacity of apartment";
        boolean IsEmpty=false;
        for(int i=0; i<getapartmentNumberBuilding() && !IsEmpty; i++){
            if(apartments[i]==null){
                apartments[i]=newApartment;
                IsEmpty=true;
                msj="apartment added";
            }
        }
        return msj;
    }

    public String addOwnerToApartment(Owner newOwner, int posApartment){
        String msj="";
        if(apartments[posApartment]!=null){
            msj=apartments[posApartment].addOwner(newOwner);
        }
        return msj;

    }
    
}


