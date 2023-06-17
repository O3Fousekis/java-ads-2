import java.util.*;

class Product {

    public int product; //kwdikos proiontos
    public int supplier;//kwdikos promithefth
    public String prdesc;//plhrofories proiontos

    Product(){
        
    }

    Product(int product, int supplier, String prdesc){
        this.product = product;
        this.supplier = supplier;
        this.prdesc = prdesc;
    }

    public int getProduct() {
        return product;
    }

    public String getPrdesc() {
        return prdesc;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setProduct(int product){
        this.product = product;
    }

    public void setPrdesc(String prdesc){
        this.prdesc = prdesc;
    }

    public void setSupplier(int supplier){
        this.supplier = supplier;
    }
    

    public String toString() {
        return " Product's code: " + this.product + " Ad's Supplier code: " + this.supplier + " Product's description: " + this.prdesc;
    }

}