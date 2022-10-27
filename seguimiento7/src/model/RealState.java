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
        for(int i=0; i<NUMBER_OF_BUILDINGS && !IsEmpty; i++){
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
    public String cheakRepeatNumberBuildingApartment(int numberApartment, String nameBuilding){
        String msj="";
        int posBuilding=searchBuildingByName(nameBuilding);
        msj=buildings[posBuilding].cheakRepeatNumberApartment(numberApartment);
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

    public String addOwnerToApartmentInBuilding(String nameBuilding, int numberApartment, String typeID, String numberId, String name, String numberContact, String typeCellmain, String nameBank, String numberBank){
        String msj="max capacity of owner in the building";
        int posBuilding=searchBuildingByName(nameBuilding);
        Person newOwner= new Owner(typeID, numberId, name, numberContact, typeCellmain, nameBank, numberBank);
        if(posBuilding!=-1){
             msj=buildings[posBuilding].addOwnerToApartment(newOwner, numberApartment);
           
        }
        return msj;
    }

    public String addTenantToApartmentInBuilding(String nameBuilding, int numberApartment, String typeID, String numberId, String name, String numberContact, String typeCellmain){
        String msj="max capacity of tenant in the building";
        int posBuilding=searchBuildingByName(nameBuilding);
        Person newTenant= new Tenant(typeID, numberId, name, numberContact, typeCellmain);
        if(posBuilding!=-1){
             msj=buildings[posBuilding].addTenantToApartment(newTenant, numberApartment);
        }
        return msj;
    }

    public String cheakRepeatTenantIDBuildingApartment(String numberId){
        String msj="";
        boolean isFound=false;
        for(int posBuilding=0; posBuilding<NUMBER_OF_BUILDINGS && !isFound; posBuilding++){
            if(buildings[posBuilding]!=null){
                for(int posApartment=0; posApartment<buildings[posBuilding].getapartmentNumberBuilding() && !isFound; posApartment++){
                    if(buildings[posBuilding].getApartments()[posApartment]!=null){
                        if(buildings[posBuilding].getApartments()[posApartment].getTenant()[0]!=null){
                            if(buildings[posBuilding].getApartments()[posApartment].getTenant()[0].getNumberId().equals(numberId)){
                                msj="this tenant already has a rented apartment";
                                isFound=true;
                            }
                        }
                    }
                }
            }
        }
        return msj;


    }

    public String showEmptyApartmentInBuildingByName(String nameBuilding){
        String msj="";
        int posBuilding=searchBuildingByName(nameBuilding);
        int counter=0;
        if(posBuilding!=-1){
            for(int i=0; i<buildings[posBuilding].getapartmentNumberBuilding();i++){
                if(buildings[posBuilding].getApartments()[i]==null){
                    counter+=1;
                    
                }else if(buildings[posBuilding].getApartments()[i]!=null){
                    if(buildings[posBuilding].getApartments()[i].getTenant()[0]==null){
                        counter+=1;
                    }else if(buildings[posBuilding].getApartments()[i].getTenant()[0]!=null){
                        counter+=0;
                    }
                }
            }
        }
        msj="the number of empty apartments is: "+counter;
        return msj;
    }
    
    public String showTotalRentInASpecificBuildingByName(String nameBuilding){
        String msj="";
        int posBuilding=searchBuildingByName(nameBuilding);
        double totalRent=0;
        if(posBuilding!=-1){
            for(int i=0; i<buildings[posBuilding].getapartmentNumberBuilding();i++){
                if(buildings[posBuilding].getApartments()[i]!=null){
                    if(buildings[posBuilding].getApartments()[i].getTenant()[0]!=null){
                        totalRent+=buildings[posBuilding].getApartments()[i].getMonthRent();
                    }
                }
            }
        }
        msj="the total rent for all the apartment in this building is: "+totalRent;
        return msj;
    }

    public String showSpecificApartmentEmpty(String nameBuilding, int numberApartment){
        String msj="";
        int posBuilding=searchBuildingByName(nameBuilding);
        if(posBuilding!=-1){
            msj=buildings[posBuilding].apartmentEmpty(numberApartment);
        }
        return msj;
    }

    
   





    

}