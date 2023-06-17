import java.util.*;

class WebAdv extends Advertisement{

    private float price;  //timh ana hmera
    private float autocost;  //kostos automaths emfanishs
    private float extracost; //timh epipleon selidas emfanishs
    private int auto;  //h yparxh automaths emfanishs (0,1)
    private int extrapages; //plh8os epipleon  selidvn
    private float totalcost;

    WebAdv(){
        
    }

    WebAdv (int adcode, String addesc, int taxid, String brand, int type,int duration, String details,int product, int supplier, String prdesc, float price, float autocost, float extracost, int auto, int extrapages, float totalcost) {
        super(adcode, addesc, taxid, brand, type, duration, details, product, supplier, prdesc, totalcost);
        
        this.price = price;
        this.autocost = autocost;
        this.extracost = extracost;
        this.auto = auto;
        this.extrapages = extrapages;
        this.totalcost = totalcost;

    }    


    public float getTotalcost(){
        this.totalcost = this.price * this.duration;
        if (this.auto == 1){
            this.totalcost += this.autocost;
        }

        this.totalcost += (this.extrapages * this.extracost);

        return totalcost;
    }

    public float getAutocost() {
        return autocost;
    }
    
    public int getExtrapages() {
        return extrapages;
    }

    public float getExtracost() {
        return extracost;
    }

    public int getAuto() {
        return auto;
    }

    public float getPrice() {
        return price;
    }

    public void setTotalcost(float totalcost) {
        this.totalcost = totalcost;
    }

    public void setAutocost(float autocost){
        this.autocost = autocost;
    }

    public void setExtracost(float extracost){
        this.extracost = extracost;
    }

    public void setAuto(int auto){
        this.auto = auto;
    }

    public void setExtrapages(int extrapages){
        this.extrapages = extrapages;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }

    public String toString(){
        String cost;
        if (this.auto == 1){
            if(this.extrapages != 0){
                cost = this.price + " * " + this.duration + " + " +  this.autocost + " + " + (this.extrapages * this.extracost) + "=" + this.totalcost;
            }
            else{
                cost = this.price + " * " + this.duration + " + " +  this.autocost + "=" + this.totalcost;
            }
        }
        else{
            if(this.extrapages != 0){
                cost = this.price + " * " + this.duration + " + " + (this.extrapages * this.extracost)+ "=" + this.totalcost;
            }
            else{
                cost = this.price + " * " + this.duration + "=" + this.totalcost;
            }
        }    
    return super.toString() + " Price per day: " + this.price + " The Ad has auto Appearance (0-No or 1-Yes): " + auto + " The Ad has " + extrapages + " extra pages" + " Ad's code > " + cost;
    }
}