package model;

import javax.swing.JSpinner.NumberEditor;

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

    public String addOwnerToApartment(Person newOwner, int numberApartment){
        String msj="this apartment already has a owner";
        int posApartment=searchApartmentByNumber(numberApartment)-1;
        msj=apartments[posApartment].addOwner(newOwner);
        return msj;

    }

    public String addTenantToApartment(Person newTenant, int numberApartment){
        String msj="this apartment already has a tenant";
        int posApartment=searchApartmentByNumber(numberApartment)-1;
        if(apartments[posApartment]!=null){
            msj=apartments[posApartment].addTenant(newTenant);
            
        }
        return msj;

    }

    

    public String cheakRepeatNumberApartment(int numberApartment){
        String msj="";
        boolean isFound=false;
        for(int i=0; i<getapartmentNumberBuilding() && !isFound; i++){
            if(apartments[i]!=null){
                if(apartments[i].getNumberApartment()==numberApartment){
                    msj="the apartment is already registed";
                    isFound=true;
                }
            }
        }
        return msj;
    }

    public int searchApartmentByNumber(int numberApartment){
        int posApartment=-1;
        boolean isFound=false;
        for(int i=0; i<getapartmentNumberBuilding() && !isFound; i++){
            if(apartments[i]!=null){
                if(apartments[i].getNumberApartment()==numberApartment){
                    posApartment=numberApartment;
                    isFound=true;
                }
            }
        }
        return posApartment;

    }
     public String apartmentEmpty(int numberApartment){
        String msj="";
        int posApartment=searchApartmentByNumber(numberApartment)-1;
        if(apartments[posApartment]!=null){
            if(apartments[posApartment].getTenant()[0]==null){
                msj="the apartment is empty";
            }else if(apartments[posApartment].getTenant()[0]!=null){
                msj="the apartment is ocupated";
            }
        }else if(apartments[posApartment]==null){
            msj="the apartment is Empty";
        }
        return msj;
     }
}


