import java.util.*;

class Companies{
    public int taxid; //afm forea
    public String name; //epwnumia

    Companies(){

    }

    Companies(int taxid, String name){
        this.taxid = taxid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTaxid() {
        return taxid;
    }

    public void setTaxid(int taxid){
        this.taxid = taxid;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString() {

        return " Company's Tax ID: " + taxid + " Company's name: " + name ;
    
    }

}