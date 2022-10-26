package model;


public class RealState{
    public static final int NUMBER_OF_BUILDINGS=10;

    private Building[] buildings;

    public RealState(){
        this.buildings=new Building[NUMBER_OF_BUILDINGS];
    }
    public Building[] getBuildings() {
        return buildings;
    }

    public void setBuildings(Building[] buildings){
		this.buildings = buildings;
	}

    public String addBuilding(String nameBuilding, int apartmentNumber, String adressBuilding){
        String msj="max capacity of building";
        Building newBuilding = new Building(nameBuilding, apartmentNumber, adressBuilding);
        boolean IsEmpty=false;
        for(int i=0; i<NUMBER_OF_BUILDINGS || !IsEmpty; i++){
            if(buildings[i]==null){
                buildings[i]=newBuilding;
                IsEmpty=true;
                msj="the building was added";
            }
        }
        return msj;
    }

    public String cheackRepeatNameBuilding(String nameBuilding){
        String msj="";
       boolean isFound=false;
        for(int i=0; i<NUMBER_OF_BUILDINGS && !isFound;i++){
            if(buildings[i]!=null){
                if(buildings[i].getNameBuilding().equals(nameBuilding)){
                    msj="the name of the building is repeated";
                    isFound=true;
                }
            }
        }
        return msj;
    }

    public String cheackRepeatAdressBuilding(String adressBuilding){
        String msj="";
       boolean isFound=false;
        for(int i=0; i<NUMBER_OF_BUILDINGS && !isFound;i++){
            if(buildings[i]!=null){
                if(buildings[i].getAdressBuilding().equals(adressBuilding)){
                    msj="the name of the building is repeated";
                    isFound=true;
                }
            }
        }
        return msj;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    public String addApartmentToBuilding(int numberApartment, int numberRoom, int numberBath, boolean balconyApartment, double monthRent, String nameBuilding){
        String msj="max capacity of apartment";
        int posBuilding=searchBuildingByName(nameBuilding);
        Apartment newApartment= new Apartment(numberApartment, numberRoom, numberBath, balconyApartment, monthRent);
        if(posBuilding!=-1){
            msj=buildings[posBuilding].addAparment(newApartment);
        }
        
        return msj;
    }

    public int searchBuildingByName(String nameBuilding){
        int posBuilding=-1;
        boolean isFound=false;
        for(int i=0; i<NUMBER_OF_BUILDINGS && !isFound;i++){
            if(buildings[i]!=null){
                if(buildings[i].getNameBuilding().equals(nameBuilding)){
                    posBuilding=i;
                    isFound=true;
                }
            }
        }
        return posBuilding;
    }

    public String addOwnerToApartmentInBuilding(String nameBuilding, int numberApartment, String typeID, String numberId, String name, String numberContact, TypeCell typeCell, String nameBank, String numberBank){
        String msj="max capacity of owner in the building";
        int posBuilding=searchBuildingByName(nameBuilding);
        Owner newOwner= new Owner(typeID, numberId, name, numberContact, typeCell, nameBank, numberBank);
        if(posBuilding!=-1){
           int posApartment=searchApartmentByNumber(numberApartment, posBuilding);
           if(posApartment!=-1){
             msj=buildings[posBuilding].addOwnerToApartment(newOwner, posApartment);
           }
        }
        return msj;
    }
    public int searchApartmentByNumber(int numberApartment, int posBuilding){
        int posApartment=-1;
        boolean isFound=false;
        for(int i=0; i<buildings[posBuilding].getapartmentNumberBuilding() && !isFound; i++){
            if(buildings[posBuilding].getApartments()[i]!=null){
                if(buildings[posBuilding].getApartments()[i]==numberApartment){
                    posApartment=numberApartment;
                    isFound=true;
                }
            }
        }

    }





    

}