import java.util.*;

class RadioAdv extends Advertisement{

    public float price; 
    public int secduration; //diarkeia diafhmishs se deuterolepta
    public int timezone; //xronikh zwnh emfanishs ths diafhmishs 
    public float totalcost;

    RadioAdv(){
        
    }

    RadioAdv(int adcode, String addesc, int taxid, String brand, int type, int duration, String details,int product, int supplier, String prdesc, float price, int secduration, int timezone,float totalcost){        
        
        super(adcode, addesc, taxid, brand, type, secduration, details, product, supplier, prdesc, totalcost);
        
        this.price = price;
        this.secduration = secduration;
        this.timezone = timezone; 
        this.totalcost = totalcost;
    }

    public float getTotalcost(){
        this.totalcost = this.secduration * this.duration * this.price;
        return totalcost;
    }

    public float getPrice() {
        return price;
    }

    public int getTimezone() {
        return timezone;
    }

    public int getSecduration() {
        return secduration;
    }

    public void setTotalcost(float totalcost){
        this.totalcost = totalcost;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSecduration(int secduration){
        this.secduration = secduration;
    }

    public void setTimezone(int timezone){
        this.timezone = timezone;
    }
    
     public String toString(){
        String cost = " Ad's cost > " + this.secduration + " * " + this.duration + " * " + price + " = " + this.totalcost;
        return super.toString() + " Price per second: " + price + " Duration (in seconds) of the Ad: " + this.secduration + " Timezone: " + this.timezone + cost;
     }
}