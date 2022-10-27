package model;

public abstract class Person{
    private String typeID;
    private String numberId;
    private String name;
    private String numberContact;
    private String typeCellmain;
    private TypeCell typeCell;

    public Person(String typeID, String numberId, String name, String numberContact, String typeCellmain){
        this.typeID=typeID;
        this.numberId=numberId;
        this.name=name;
        this.numberContact=numberContact;
        this.typeCellmain=typeCellmain;
        setTypeCell(typeCellmain);
        
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    //--------------------------------------------------------

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    //--------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //--------------------------------------------------------

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }
    //--------------------------------------------------------

    public String getTypeCellmain() {
        return typeCellmain;
    }

    public void setTypeCellmain(String typeCellmain) {
        this.typeCellmain = typeCellmain;
    }
    
    //--------------------------------------------------------
    
    public TypeCell getTypeCell() {
        return typeCell;
    }

    public void setTypeCell(String typeCellmain) {
        typeCellmain=typeCellmain.toLowerCase();
        if(typeCellmain.equals("home")){
            typeCell=TypeCell.HOME;
        }else if(typeCellmain.equals("office")){
            typeCell=TypeCell.OFFICE;
        }else if(typeCellmain.equals("movil")){
            typeCell=TypeCell.MOVIL;
        }else if(typeCellmain.equals("family")){
            typeCell=TypeCell.FAMILY;
        }else{
            typeCell=TypeCell.OTHER;
        }
    }

    //--------------------------------------------------------
}
