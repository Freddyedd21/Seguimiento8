package model;

public abstract class Person{
    private String typeID;
    private String numberId;
    private String name;
    private String numberContact;
    private TypeCell typeCell;

    public Person(String typeID, String numberId, String name, String numberContact, TypeCell typeCell){
        this.typeID=typeID;
        this.numberId=numberId;
        this.name=name;
        this.numberContact=numberContact;
        this.typeCell=typeCell;
    }

    public TypeID getTypeID() {
        return typeID;
    }

    public void setTypeID(TypeID typeID) {
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
    
    public TypeCell getTypeCell() {
        return typeCell;
    }

    public void setTypeCell(TypeCell typeCell) {
        this.typeCell = typeCell;
    }

    //--------------------------------------------------------
}
