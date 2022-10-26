package ui;

import java.util.Scanner;

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
        "4. Bajar a una persona del carro autonomo\n" +
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

        String typeID;
        String numberId; 
        String name;
        String numberContact; 
        TypeCell typeCell; 
        String typeOfCell;
        String nameBank; 
        String numberBank;

            switch(option){
                case 1: 
                    case1(msj, nameBuilding, apartmentNumberBuilding, adressBuilding);
                    break; 

                case 2: 
                   case2(msj, numberApartment, numberRoom, numberBath, balconyApartment, monthRent, nameBuilding, counter, choices);
                    break; 

                case 3: 
                    
                    break;

                case 4: 

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
            if(numberApartment>0 && numberApartment<=realStates.getBuildings()[counter].getapartmentNumberBuilding()){
                System.out.println("type the rooms number of the aparment");
                numberRoom=reader.nextInt();
                System.out.println("type the number of bath of the aparment");
                numberBath=reader.nextInt();
                do{
                 System.out.println("type -y- if the apartment has balcony, type -n- if the aparment haeve not a balcony");
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
                System.out.println("this number of apartment doesnt exist");
            }
        }
        
    
    }

    public void case3(){

    }



}



