import java.util.*;

class PrintedAdv extends Advertisement{

    int wordcount; //plhthos leksewn
    float pageprice; //chosen page word price
    int listingpos; //thesh sto entipo
    public float totalcost;

    PrintedAdv(){
        
    }

    PrintedAdv(int adcode, String addesc, int taxid, String brand, int type,int duration, String details,int product, int supplier, String prdesc, int wordcount, float pageprice, int listingpos, float totalcost){        
        
        super(adcode, addesc, taxid, brand, type, duration, details, product, supplier, prdesc, totalcost);

        this.wordcount = wordcount;
        this.pageprice = pageprice;
        this.listingpos = listingpos;
    
    }

    public float getTotalcost(){
        this.totalcost = this.pageprice*this.duration*this.wordcount;
        return totalcost;
    }
    
    public int getWordcount() {
        return wordcount;
    }

    public int getListingpos() {
        return listingpos;
    }

    public float getPageprice() {
        return pageprice;
    }

    public void setTotalcost(float totalcost) {
        this.totalcost = totalcost;
    }

    public void setPageprice(float pageprice) {
        this.pageprice = pageprice;
    }

    public void setWordcount(int wordcount) {
        this.wordcount = wordcount;
    }

    public void setListingpos(int listingpos) {
        this.listingpos = listingpos;
    }

    public String toString(){
        String cost = " Ad's cost > Duration: "+ this.duration +" + Page price: "+ this.pageprice +" = Total cost: "+ this.totalcost;
        return super.toString() + " Word Count: " + this.wordcount + " Page Price: " + this.pageprice + " Listing position: " + this.listingpos + cost ;
    }

}