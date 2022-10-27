package model;

public class Owner extends Person{
    private String nameBank;
    private String numberBank;

    public Owner(String typeID, String numberId, String name, String numberContact,  String typeCellmain, String nameBank, String numberBank){
        super(typeID, numberId, name, numberContact, typeCellmain);
        this.nameBank=nameBank;
        this.numberBank=numberBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    //--------------------------------------------------------

    public String getNumberBank() {
        return numberBank;
    }

    public void setNumberBank(String numberBank) {
        this.numberBank = numberBank;
    }

    

    
}