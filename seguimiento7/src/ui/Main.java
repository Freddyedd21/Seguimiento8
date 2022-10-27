package ui;

import java.util.Scanner;

import model.Building;
import model.RealState;

public class Main{

    private Scanner reader;
    private RealState realStates;

    public Main(){
        reader=new Scanner(System.in);
      
        realStates = new RealState(); 

    }


    public Scanner getReader(){
        return this.reader;
    }
    public void setReader(Scanner reader){
        this.reader=reader;
    }

    public static void main(String[] args){
        Main main=new Main();
        int option = -1; 
			do{

				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

		}

        

    

    public String printMenu(){
        return
        "<< --------------------------------------------------------------------- >>\n" +
        "<< -                                Welcome                            - >>\n" +
        "<< --------------------------------------------------------------------- >>\n" +
        "1. Add building \n" +
        "2. Add apartment to a building\n" + 
        "3. Add owner of a apartment\n" +
        "4. add tenant of a apartment\n" +
        "5. show empty apartments\n"+
        "6. show total rent of a building\n"+
        "7. show the availability of a specific apartment\n"+
        "0. exit program";
    
    }
    public int validateIntegerOption(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            // clear reader. 
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }

    public int getOptionShowMenu(){
        int option = 0; 
        System.out.println(printMenu());

        option = validateIntegerOption(); 

        return option; 
    }
    public void executeOption(int option){
        String msj="";
        int counter=0;
        int choices =0;

        String nameBuilding="";
        int apartmentNumberBuilding=0;
        String adressBuilding="";

        int numberApartment=0;
        int numberRoom=0;
        int numberBath=0;
        boolean balconyApartment=false;
        double monthRent=0;

        String typeID="";
        String numberId=""; 
        String name="";
        String numberContact=""; 
        String typeCellmain=""; 
        String nameBank=""; 
        String numberBank="";

            switch(option){
                case 1: 
                    case1(msj, nameBuilding, apartmentNumberBuilding, adressBuilding);
                    break; 

                case 2: 
                    case2(msj, numberApartment, numberRoom, numberBath, balconyApartment, monthRent, nameBuilding, counter, choices);
                    break; 

                case 3: 
                    case3(msj, nameBuilding, numberApartment, typeID, numberId, name, numberContact, typeCellmain, nameBank, numberBank);
            
                    break;

                case 4: 
                    case4(msj, nameBuilding, numberApartment, typeID, numberId, nameBank, numberContact, typeCellmain);
                    break;

                case 5:
                    case5(msj, nameBuilding);
                    break;

                case 6:
                    case6(msj, nameBuilding);
                    break;
                case 7:
                    case7(msj, nameBuilding, numberApartment);
                    break;
                case 0: 
                    System.out.println("Exit program.");
                    break; 

                default: 
                    System.out.println("Invalid Option");
                    break; 
            }
    }


    public void case1(String msj, String nameBuilding, int apartmentNumberBuilding, String adressBuilding){
        msj="";
        System.out.println("type the name of the building");
        nameBuilding= reader.next();
        msj=realStates.cheackRepeatNameBuilding(nameBuilding);
        if (msj.equals("")) {
            System.out.println("type the number of apartment");
            apartmentNumberBuilding = reader.nextInt();
            System.out.println("type the adress of the building");
            msj=realStates.cheackRepeatAdressBuilding(adressBuilding);
            if(msj.equals("")){
                adressBuilding = reader.next();
                msj = realStates.addBuilding(nameBuilding, apartmentNumberBuilding, adressBuilding);
            }
            
            
        }
        System.out.println(msj);
    
    }

    public void case2(String msj, int numberApartment, int numberRoom, int numberBath, boolean balconyApartment, double monthRent, String nameBuilding, int counter, int choices){
        msj="";
        System.out.println("type the name of the building to add the apartment");
        nameBuilding=reader.next();
        counter=realStates.searchBuildingByName(nameBuilding);
        if(counter==-1){
            System.out.println("building havent found");
        }else{
            System.out.println("type the number of the aparment that you want to add");
            numberApartment=reader.nextInt();
            msj=realStates.cheakRepeatNumberBuildingApartment(numberApartment, nameBuilding);
            if(numberApartment>0 && numberApartment<=realStates.getBuildings()[counter].getapartmentNumberBuilding()){
                if(msj.equals("")){
                    System.out.println("type the rooms number of the aparment");
                    numberRoom=reader.nextInt();
                    System.out.println("type the number of bath of the aparment");
                    numberBath=reader.nextInt();
                    do{
                     System.out.println("type -1- if the apartment has balcony, type -2- if the aparment haeve not a balcony");
                     choices=reader.nextInt();
                    }while((choices!=1) && (choices!=2));
                    if(choices==1){
                       balconyApartment=true;
                    }else if(choices==2){
                       balconyApartment=false;
                    }
                    System.out.println("type the month rent of the apartment");
                    monthRent=reader.nextDouble();
                    msj=realStates.addApartmentToBuilding(numberApartment, numberRoom, numberBath, balconyApartment, monthRent, nameBuilding);
                    System.out.println(msj);
                }else{
                    System.out.println(msj);
                }
                
            }else{
                System.out.println("this number of apartment doesnt exist");
            }
        }
        
    
    }

    public void case3(String msj, String nameBuilding, int numberApartment, String typeID, String numberId, String name, String numberContact, String typeCellmain, String nameBank, String numberBank){
        msj="";
        System.out.println("type the name of the building to add the owner");
        nameBuilding=reader.next();
        int posBuilding=realStates.searchBuildingByName(nameBuilding);
        if(posBuilding==-1){
            System.out.println("building havent found");
        }else{
            System.out.println("type the number of the aparment that you want to add a owner");
            numberApartment=reader.nextInt();
            int posApartment=realStates.getBuildings()[posBuilding].searchApartmentByNumber(numberApartment);
            if(numberApartment>0 && numberApartment<=realStates.getBuildings()[posBuilding].getapartmentNumberBuilding()){
                if(posApartment==-1){
                    System.out.println("the apartment is not registered"); 
                }else{
                    System.out.println("type the type of id of the owner");
                    typeID=reader.next();
                    System.out.println("type the number id of the owner");
                    numberId=reader.next();
                    System.out.println("type the name of the owner");
                    name=reader.next();
                    System.out.println("type the number of conctact of the owner");
                    numberContact=reader.next();
                    System.out.println("type the type of cellphone of the owner");
                    typeCellmain=reader.next();
                    System.out.println("write the name of the bank in which the owner has an account");
                    nameBank=reader.next();
                    System.out.println("type the number of account of the owner");
                    numberBank=reader.next();
                    msj=realStates.addOwnerToApartmentInBuilding(nameBuilding, numberApartment, typeID, numberId, name, numberContact, typeCellmain, nameBank, numberBank);
                    System.out.println(msj);
                }
            }else{
                System.out.println("this number of apartment doesnt exist");
            }
        }
        
    }

    public void case4(String msj, String nameBuilding, int numberApartment, String typeID, String numberId, String name, String numberContact, String typeCellmain){
        msj="";
        System.out.println("type the name of the building to add the tenant");
        nameBuilding=reader.next();
        int posBuilding=realStates.searchBuildingByName(nameBuilding);
        if(posBuilding==-1){
            System.out.println("building havent found");
        }else{
            System.out.println("type the number of the aparment that you want to add a tenant");
            numberApartment=reader.nextInt();
            int posApartment=realStates.getBuildings()[posBuilding].searchApartmentByNumber(numberApartment);
            if(numberApartment>0 && numberApartment<=realStates.getBuildings()[posBuilding].getapartmentNumberBuilding()){
                if(posApartment==-1){
                    System.out.println("the apartment is not registered"); 
                }else{
                    System.out.println("type the type of id of the tenant");
                    typeID=reader.next();
                    System.out.println("type the number id of the tenant");
                    numberId=reader.next();
                    msj=realStates.cheakRepeatTenantIDBuildingApartment(numberId);
                    if(msj.equals("")){
                        System.out.println("type the name of the tenant");
                        name=reader.next();
                        System.out.println("type the number of conctact of the tenant");
                        numberContact=reader.next();
                        System.out.println("type the type of cellphone of the tenant");
                        typeCellmain=reader.next();
                        msj=realStates.addTenantToApartmentInBuilding(nameBuilding, numberApartment, typeID, numberId, name, numberContact, typeCellmain);
                        System.out.println(msj);
                    }else{
                        System.out.println(msj);
                    }
                }
            }else{
                System.out.println("this number of apartment doesnt exist");
            }
        }
        
    }

    public void case5(String msj, String nameBuilding){
        System.out.println("type the name of the building to show its empty apartments");
        nameBuilding=reader.next();
        int posBuilding=realStates.searchBuildingByName(nameBuilding);
        if(posBuilding==-1){
            System.out.println("building havent found");
        }else{
            msj=realStates.showEmptyApartmentInBuildingByName(nameBuilding);
            System.out.println(msj);
        }
        
    }

    public void case6(String msj, String nameBuilding){
        System.out.println("type the name of the building to show the total rent");
        nameBuilding=reader.next();
        int posBuilding=realStates.searchBuildingByName(nameBuilding);
        if(posBuilding==-1){
            System.out.println("building havent found");
        }else{
            msj=realStates.showTotalRentInASpecificBuildingByName(nameBuilding);
            System.out.println(msj);
        }
    }

    public void case7(String msj, String nameBuilding, int numberApartment){
        System.out.println("type the name of the building to show a specific apartment");
        nameBuilding=reader.next();
        int posBuilding=realStates.searchBuildingByName(nameBuilding);
        if(posBuilding==-1){
            System.out.println("building havent found");
        }else{
            System.out.println("type the number of the apartment");
            numberApartment=reader.nextInt();
            int posApartment=realStates.getBuildings()[posBuilding].searchApartmentByNumber(numberApartment);
            if(posApartment==-1){
                System.out.println("apartment not registered");
            }else{
                msj=realStates.showSpecificApartmentEmpty(nameBuilding, numberApartment);
                System.out.println(msj);
            }
            
        }
    }
    


}



