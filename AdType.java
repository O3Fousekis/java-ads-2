import java.util.*;

class AdType {
    public int adcode; //kwdikos diafhmishs
    public String addesc; //perigrafh diafhmishs

    AdType(){

    }

    AdType(int adcode,String addesc){
        this.adcode = adcode;
        this.addesc = addesc;
    }

    public int getAdcode() {
        return adcode;
    }

    public String getAddesc() {
        return addesc;
    }

    public void setAdcode(int adcode){
        this.adcode = adcode;
    }

    public void setAddesc(String addesc){
        this.addesc = addesc;
    }



    public String toString() {

        return " Ad's code: " + adcode + " Ad's description: " + addesc;
 
    }

}