import java.util.*;

class Advertisement{
    

    public Companies comp; 
    public int taxid;
    public Product prod;
    public int duration; //diarkeia diafhmishs se meres
    public String details; //aitiologia
    public AdType adtype;
    public int type;
    public float totalcost;
    public int product; //kwdikos proiontos
    public int adcode;
    public String addesc;
    public String brand;
    public int supplier;
    public String prdesc;

    Advertisement(){
        
    }

    Advertisement(int adcode, String addesc, int taxid, String brand, int type, int duration, String details, int product, int supplier, String prdesc, float totalcost){
        
        this.comp = new Companies(taxid, brand);
        this.prod = new Product(product, supplier, prdesc);
        this.duration = duration;
        this.details = details;
        this.adtype = new AdType(adcode, addesc);
        this.taxid = taxid;
        this.type = type;
        this.totalcost = totalcost;
        this.product = product;
        this.adcode = adcode;
        this.addesc = addesc;
        this.brand = brand;
        this.supplier = supplier;
        this.prdesc = prdesc;
    }

    public int getTaxid(){
        return this.taxid;
    }

    public int getType() {
        return type;
    }

    public float getTotalcost() {
        return totalcost;
    }

    public int getProduct() {
        return product;
    }

    public int getAdcode() {
        return adcode;
    }

    public String getAddesc() {
        return addesc;
    }

    public AdType getAdtype() {
        return adtype;
    }

    public String getBrand() {
        return brand;
    }

    public Companies getComp() {
        return comp;
    }

    public String getDetails() {
        return details;
    }

    public int getDuration() {
        return duration;
    } 

    public String getPrdesc() {
        return prdesc;
    }

    public Product getProd() {
        return prod;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setAdtype(AdType adtype) {
        this.adtype = adtype;
    }

    public void setComp(Companies comp) {
        this.comp = comp;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    } 

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public void setTaxid(int taxid) {
        this.taxid = taxid;
    }

    public void setTotalcost(float totalcost) {
        this.totalcost = totalcost;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public void setAdcode(int adcode) {
        this.adcode = adcode;
    }

    public void setAddesc(String addesc) {
        this.addesc = addesc;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public void setPrdesc(String prdesc) {
        this.prdesc = prdesc;
    }

    public String toString() {

        return "--" + this.adtype.toString() + this.prod.toString() + this.comp.toString() + " Ad's Duration: " + this.duration + " Ad's Details: " + this.details + this.totalcost;

    }
    
}
