/*
    Omada xrhstwn: 067

	Name: Alexandra Maraslidou
	Student Number: 3220117
    Name: Panagiotis Moschoulis
    Student Number: 3220125
    Name: Konstantinos Sotiriou
    Student Number: 3220289 

*/

import java.util.*;

import java.io.*;

class mainApp {                                                  


    public static void main(String args[]){

        Scanner in = new Scanner(System.in); 



        HashMap <Integer , Companies> Carriers = new HashMap <Integer , Companies>(); //syllogh forewn diafhmishs
        HashMap <Integer, Product> Products = new HashMap <Integer , Product>();  //syllogh proiontwn
        HashMap <Integer, AdType> Adtypes = new HashMap <Integer, AdType>();    //syllogh twn typwn diafhmisewn
        HashMap <Integer, Advertisement> Ads = new HashMap <Integer, Advertisement>();  //syllogh diafhmisewn

        HashMap <Integer, Integer> Plurality = new HashMap <Integer, Integer>(); //plh8os diafhmisewn ana proion
        HashMap <Integer, Float> ProductSum = new HashMap<Integer, Float>(); //kostos ana proion

        ArrayList <Integer> typelist = new ArrayList<Integer>();
        ArrayList <Integer> productlist = new ArrayList<Integer>();
        ArrayList <Integer> companylist = new ArrayList<Integer>();

        int type, adcode,taxid,product,supplier, duration, wordcount, listingpos, secduration, timezone, auto, extrapages, j, option, tax=0, prcode, adcd=0;
        float pageprice, radioprice, autocost,extracost,webprice,totalcost=0,cost;
        String addesc, brand, prdesc,details;

        BufferedReader reader = null;
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        BufferedReader reader3 = null;

        Companies comp = null;
        Product item = null;
        AdType adType = null;
        String line;

        //reading Carriers.txt
        try {
            reader = new BufferedReader(new FileReader("Carriers.txt"));
            line = reader.readLine();
            if(line.trim().equals("COMPANY_LIST" ) || line.trim().equals("company_list")){
                line = reader.readLine();
                if (line.trim().equals("{")){
                    line = reader.readLine();
                    while (line !=null) {
                        if (line.trim().equals("COMPANY") || line.trim().equals("company")){
                            comp = new Companies();
                            line = reader.readLine();
                            if (line.trim().equals("{")) {
                                line = reader.readLine();
                                if (line.trim().startsWith("AFM ") || line.trim().startsWith("afm ")){
                                    comp.setTaxid(Integer.parseInt(line.trim().substring(4)));
                                    tax = comp.getTaxid();      //gia na mpei ws key sth hashmap
                                }
                                line = reader.readLine();
                                if (line.trim().startsWith("NAME ") || line.trim().startsWith("name ")){
                                    comp.setName(line.trim().substring(5));
                                }
                                line = reader.readLine();
                                if(line.trim().equals("}")){
                                    Carriers.put(tax, comp);
                                }
                                
                            }
                        }
                        line = reader.readLine(); 
                    }
                    System.out.println("Carriers successfully read.");
                    System.out.println("--------------------------------------------");
                    System.out.println("");
                    reader.close();
                               
                }
            }
        }
        catch(IOException e){
            System.out.println("Error reading line ...");
        }
    
        //reading Products.txt
        prcode = 0;
        try {
            reader1 = new BufferedReader(new FileReader("Products.txt"));
            line = reader1.readLine();
            if(line.trim().equals("ITEM_LIST") || line.trim().equals("item_list")){
                line = reader1.readLine();
                if (line.trim().equals("{")){
                    line = reader1.readLine();
                    while (line !=null) {
                        if (line.trim().equals("ITEM") || line.trim().equals("item")){
                            line = reader1.readLine();
                            if (line.trim().equals("{")){
                                line = reader1.readLine();
                                item = new Product();
                                if (line.trim().startsWith("CODE ") || line.trim().startsWith("code ")){
                                    item.setProduct(Integer.parseInt(line.trim().substring(5)));
                                    prcode = item.getProduct();      //gia na mpei ws key sth hashmap
                                }
                                line = reader1.readLine();
                                if (line.trim().startsWith("DESCR ") || line.trim().startsWith("descr ")){
                                    item.setPrdesc(line.trim().substring(6));
                                }
                                line = reader1.readLine();
                                if (line.trim().startsWith("AFM ")|| line.trim().startsWith("afm ")){
                                    item.setSupplier(Integer.parseInt(line.trim().substring(4)));
                                }
                                line = reader1.readLine();
                                if(line.trim().equals("}")){
                                    Products.put(prcode, item);
                                }
                            }        
                        }
                        line = reader1.readLine();
                    }
                    System.out.println("Products sucessfully read.");
                    System.out.println("--------------------------------------------");
                    System.out.println("");
                    reader1.close();
                }        
            }
        }
        catch(IOException e){
            System.out.println("Error reading line ...");
        }

        //reading AdTypes.txt
        try {
            reader2 = new BufferedReader(new FileReader("AdTypes.txt"));
            line = reader2.readLine();
            if(line.trim().equals("ADVTYPE_LIST") || line.trim().equals("advtype_list")){
                line = reader2.readLine();
                if (line.trim().equals("{")){
                    line = reader2.readLine();
                    while (line !=null) {
                        if (line.trim().equals("ADVTYPE") || line.trim().equals("advtype")){
                            line = reader2.readLine();
                            if (line.trim().equals("{")){
                                line = reader2.readLine();
                                adType = new AdType();
                                if (line.trim().startsWith("ADCODE ") || line.trim().startsWith("adcode ")){
                                    adType.setAdcode(Integer.parseInt(line.trim().substring(7)));
                                    adcd = adType.getAdcode();      //gia na mpei ws key sth hashmap
                                }
                                line = reader2.readLine();
                                if (line.trim().startsWith("DESCR ") || line.trim().startsWith("descr ")){
                                    adType.setAddesc(line.trim().substring(6));
                                }
                                line = reader2.readLine();
                                if(line.trim().equals("}")){
                                    Adtypes.put(adcd, adType);
                                }
                            }    
                        }
                        line = reader2.readLine();
                    }
                    System.out.println("Ad types successfully read.");
                    System.out.println("--------------------------------------------");
                    System.out.println("");
                    reader2.close();
                }        
            }
        }
        catch(IOException e){
            System.out.println("Error reading line ...");
        }

        //reading Ads.txt
        try {
            reader3 = new BufferedReader(new FileReader("Ads.txt"));
            line = reader3.readLine();
            if(line.trim().equals("ADV_LIST") || line.trim().equals("adv_list")){
                line = reader3.readLine();
                if (line.trim().equals("{")){
                    line = reader3.readLine();
                    while (line !=null && !line.trim().equals("}")) {
                        if (line.trim().equals("ADVTYPE") || line.trim().equals("advtype")){
                            line = reader3.readLine();
                            if (line.trim().equals("{")){
                                line = reader3.readLine();
                                if (line.trim().startsWith("TYPE ") || line.trim().startsWith("type ")){                                     
                                    if (line.trim().substring(5).trim().equals("1")){
                                        PrintedAdv advert1 = new PrintedAdv();
                                        adType = new AdType(); //arxikopoihsh
                                        advert1.setType(Integer.parseInt(line.trim().substring(5)));
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("ADVTYPE_CODE ") || line.trim().startsWith("advtype_code ")){
                                            advert1.setAdcode(Integer.parseInt(line.trim().substring(13)));
                                            adcd = advert1.getAdcode();
                                            adType.setAdcode(adcd); //set adcode sthn adtype
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DESCR ") || line.trim().startsWith("descr ")){
                                            advert1.setAddesc(line.trim().substring(6));
                                            adType.setAddesc(advert1.getAddesc()); //set addesc sthn adtype
                                        }
                                        advert1.setAdtype(adType);
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("AFM ") || line.trim().startsWith("afm ")){
                                            advert1.setTaxid(Integer.parseInt(line.trim().substring(4)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("COMPANY ") || line.trim().startsWith("company ")){
                                            advert1.setBrand(line.trim().substring(8));
                                            Companies company = new Companies(advert1.getTaxid(), advert1.getBrand());
                                            advert1.setComp(company);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DURATION ") || line.trim().startsWith("duration ")){
                                            advert1.setDuration(Integer.parseInt(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DETAILS ") || line.trim().startsWith("details ")){
                                            advert1.setDetails(line.trim().substring(8));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("ITEM_CODE ") || line.trim().startsWith("item_code ")){
                                            advert1.setProduct(Integer.parseInt(line.trim().substring(10)));
                                            int productCode = advert1.getProduct();
                                            Product prod = Products.get(productCode);
                                            advert1.setProd(prod);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("SUPPLIER ") || line.trim().startsWith("supplier ")){
                                            advert1.setSupplier(Integer.parseInt(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("PRODUCTDESCR ") || line.trim().startsWith("productdescr ")){
                                            advert1.setPrdesc(line.trim().substring(13));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("TOTALCOST ") || line.trim().startsWith("totalcost ")){
                                            advert1.setTotalcost(Float.parseFloat(line.trim().substring(10)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("WORDCOUNT ") || line.trim().startsWith("wordcount ")){
                                            advert1.setWordcount(Integer.parseInt(line.trim().substring(10)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("PAGEPRICE ") || line.trim().startsWith("pageprice ")){
                                            advert1.setPageprice(Float.parseFloat(line.trim().substring(10)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("LISTINGPOS ") || line.trim().startsWith("listingpos ")){
                                            advert1.setListingpos(Integer.parseInt(line.trim().substring(11)));
                                        }
                                        line = reader3.readLine(); 
                                        if(line.trim().equals("}")){
                                            Ads.put(adcd,advert1);
                                        }
                                    }
                                    else if (line.trim().substring(5).trim().equals("2")){
                                        RadioAdv advert1 = new RadioAdv();
                                        adType = new AdType();
                                        advert1.setType(Integer.parseInt(line.trim().substring(5)));
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("ADVTYPE_CODE ") || line.trim().startsWith("advtype_code ")){
                                            advert1.setAdcode(Integer.parseInt(line.trim().substring(13)));
                                            adcd = advert1.getAdcode();
                                            adType.setAdcode(adcd);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DESCR ") || line.trim().startsWith("descr ")){
                                            advert1.setAddesc(line.trim().substring(6));
                                            adType.setAddesc(advert1.getAddesc());
                                        }
                                        advert1.setAdtype(adType);
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("AFM ") || line.trim().startsWith("afm ")){
                                            advert1.setTaxid(Integer.parseInt(line.trim().substring(4)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("COMPANY ") || line.trim().startsWith("company ")){
                                            advert1.setBrand(line.trim().substring(8));
                                            Companies company = new Companies(advert1.getTaxid(), advert1.getBrand());
                                            advert1.setComp(company);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DURATION ") || line.trim().startsWith("duration ")){
                                            advert1.setDuration(Integer.parseInt(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DETAILS ") || line.trim().startsWith("details ")){
                                            advert1.setDetails(line.trim().substring(8));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("ITEM_CODE ") || line.trim().startsWith("item_code ")){
                                            advert1.setProduct(Integer.parseInt(line.trim().substring(10)));
                                            int productCode = advert1.getProduct();
                                            Product prod = Products.get(productCode);
                                            advert1.setProd(prod);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("SUPPLIER ") || line.trim().startsWith("supplier ")){
                                            advert1.setSupplier(Integer.parseInt(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("PRODUCTDESCR ") || line.trim().startsWith("productdescr ")){
                                            advert1.setPrdesc(line.trim().substring(13));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("TOTALCOST ") || line.trim().startsWith("totalcost ")){
                                            advert1.setTotalcost(Float.parseFloat(line.trim().substring(10)));
                                        }
                                        line = reader3.readLine();
                                        if(line.trim().startsWith("SECPRICE ") || line.trim().startsWith("secprice ")){
                                            advert1.setPrice(Float.parseFloat(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if(line.trim().startsWith("SECDURATION ") || line.trim().startsWith("secduration ")){
                                            advert1.setSecduration(Integer.parseInt(line.trim().substring(12)));
                                        }
                                        line = reader3.readLine();
                                        if(line.trim().startsWith("TIMEZONE ") || line.trim().startsWith("timezone ")){
                                            advert1.setTimezone(Integer.parseInt(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();  
                                        if(line.trim().equals("}")){
                                            Ads.put(adcd,advert1);
                                        }
                                    }
                                    else if (line.trim().substring(5).trim().equals("3")){
                                        WebAdv advert1 = new WebAdv();
                                        adType = new AdType(); 
                                        advert1.setType(Integer.parseInt(line.trim().substring(5)));
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("ADVTYPE_CODE ") || line.trim().startsWith("advtype_code ")){
                                            advert1.setAdcode(Integer.parseInt(line.trim().substring(13)));
                                            adcd = advert1.getAdcode();
                                            adType.setAdcode(adcd);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DESCR ") || line.trim().startsWith("descr ")){
                                            advert1.setAddesc(line.trim().substring(6));
                                            adType.setAddesc(advert1.getAddesc());
                                        }
                                        advert1.setAdtype(adType);
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("AFM ") || line.trim().startsWith("afm ")){
                                            advert1.setTaxid(Integer.parseInt(line.trim().substring(4)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("COMPANY ") || line.trim().startsWith("company ")){
                                            advert1.setBrand(line.trim().substring(8));
                                            Companies company = new Companies(advert1.getTaxid(), advert1.getBrand());
                                            advert1.setComp(company);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DURATION ") || line.trim().startsWith("duration ")){
                                            advert1.setDuration(Integer.parseInt(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DETAILS ") || line.trim().startsWith("details ")){
                                            advert1.setDetails(line.trim().substring(8));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("ITEM_CODE ") || line.trim().startsWith("item_code ")){
                                            advert1.setProduct(Integer.parseInt(line.trim().substring(10)));
                                            int productCode = advert1.getProduct();
                                            Product prod = Products.get(productCode);
                                            advert1.setProd(prod);
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("SUPPLIER ") || line.trim().startsWith("supplier ")){
                                            advert1.setSupplier(Integer.parseInt(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("PRODUCTDESCR ") || line.trim().startsWith("productdescr ")){
                                            advert1.setPrdesc(line.trim().substring(13));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("TOTALCOST ") || line.trim().startsWith("totalcost ")){
                                            
                                            advert1.setTotalcost(Float.parseFloat(line.trim().substring(10)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("DAYPRICE ") || line.trim().startsWith("dayprice ")){
                                            advert1.setPrice(Float.parseFloat(line.trim().substring(9)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("AUTOCOST ") || line.trim().startsWith("autocost ")){
                                            advert1.setAutocost((Float.parseFloat(line.trim().substring(9))));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("EXTRACOST ") || line.trim().startsWith("extracost ")){
                                            advert1.setExtracost((Float.parseFloat(line.trim().substring(10))));
                                        }
                                        line = reader3.readLine(); 
                                        if (line.trim().startsWith("AUTO ") || line.trim().startsWith("auto ")){
                                            advert1.setAuto(Integer.parseInt(line.trim().substring(5)));
                                        }
                                        line = reader3.readLine();
                                        if (line.trim().startsWith("EXTRAPAGES ") || line.trim().startsWith("extrapages ")){
                                            advert1.setExtrapages(Integer.parseInt(line.trim().substring(11)));
                                        }
                                        line = reader3.readLine();                                                                                    
                                        if(line.trim().equals("}")){
                                            Ads.put(adcd,advert1);
                                        }
                                    }
                                    line = reader3.readLine();
                                }
                            }              
                        } 
                    }
                    System.out.println("Ads successfully read.");
                    System.out.println("--------------------------------------------");
                    System.out.println("");
                    reader3.close();
                }
            }
        }
        
        catch(IOException e){
            System.out.println("Error reading line ...");
        }

        while(true) {
            System.out.println();
            System.out.println("------------------- MENU -------------------");
            System.out.println();
            System.out.println("0) Exit Program");
            System.out.println("1) Add new Ad Carrier ");
            System.out.println("2) Add new Ad Type ");
            System.out.println("3) Add new Advertisement ");
            System.out.println("4) Advertisement List");
            System.out.println("5) Advertisement List of one carrier");
            System.out.println("6) Total Cost of one Carrier");
            System.out.println("7) List for Sum of Advertisements for one Product");
            System.out.println("8) Total Cost of one Product");
            System.out.println("9) List of Costs for one Product");
            System.out.println("10) Update .txt File");
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.println();

            for(int i : Adtypes.keySet()){
                if( !typelist.contains(i)){
                    typelist.add(i);
                }    
            }
    
            for(int i : Products.keySet()){
                if(!productlist.contains(i)){
                    productlist.add(i);
                }    
            }
    
            for(int i : Carriers.keySet()){
                if(!companylist.contains(i)){
                    companylist.add(i);
                }   
            }
            
            System.out.print("Choose an option: ");
            int answer = in.nextInt();

            if(answer == 0 || answer == 10){
                
                try (FileWriter writer = new FileWriter("Ads.txt")) {
					writer.write(""); // Write an empty string to clear the content
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				
				try (FileWriter writer = new FileWriter("AdTypes.txt")) {
					writer.write(""); // Write an empty string to clear the content
				} 
				catch (IOException e) {
					e.printStackTrace();
				}

                FileWriter writer1 = null;
                FileWriter writer2 = null;

				try	{
					writer1 = new FileWriter(new File("Ads.txt"));
                    writer1.write("ADV_LIST"+"\n"+"{");
					for (Advertisement adv : Ads.values()){

						if (adv instanceof PrintedAdv) {
							writer1.write ("\n"+"\t"+"ADVTYPE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"TYPE "+ adv.getType()
										+ "\n"+"\t"+"\t"+"ADVTYPE_CODE " + adv.getAdcode()
										+ "\n"+"\t"+"\t"+"DESCR " + adv.getAddesc()
										+ "\n"+"\t"+"\t"+"AFM "	+ adv.getTaxid()
										+ "\n"+"\t"+"\t"+"COMPANY " + adv.getBrand()
                                        + "\n"+"\t"+"\t"+"DURATION " + adv.getDuration()
                                        + "\n"+"\t"+"\t"+"DETAILS " + adv.getDetails()
                                        + "\n"+"\t"+"\t"+"ITEM_CODE " + adv.getProduct()
                                        + "\n"+"\t"+"\t"+"SUPPLIER " + adv.getSupplier()
                                        + "\n"+"\t"+"\t"+"PRODUCTDESCR " + adv.getPrdesc()
                                        + "\n"+"\t"+"\t"+"TOTALCOST " +adv.getTotalcost()
                                        + "\n"+"\t"+"\t"+"WORDCOUNT " + ((PrintedAdv) adv).getWordcount()
                                        + "\n"+"\t"+"\t"+"PAGEPRICE " + ((PrintedAdv) adv).getPageprice()
                                        + "\n"+"\t"+"\t"+"LISTINGPOS " + ((PrintedAdv) adv).getListingpos()
										+ "\n"+"\t"+"}");
						}//printed adv
						else if (adv instanceof RadioAdv) {
								writer1.write ("\n"+"\t"+"ADVTYPE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"TYPE "+ adv.getType()
										+ "\n"+"\t"+"\t"+"ADVTYPE_CODE " + adv.getAdcode()
										+ "\n"+"\t"+"\t"+"DESCR " + adv.getAddesc()
										+ "\n"+"\t"+"\t"+"AFM "	+ adv.getTaxid()
										+ "\n"+"\t"+"\t"+"COMPANY " + adv.getBrand()
                                        + "\n"+"\t"+"\t"+"DURATION " + adv.getDuration()
                                        + "\n"+"\t"+"\t"+"DETAILS " + adv.getDetails()
                                        + "\n"+"\t"+"\t"+"ITEM_CODE " + adv.getProduct()
                                        + "\n"+"\t"+"\t"+"SUPPLIER " + adv.getSupplier()
                                        + "\n"+"\t"+"\t"+"PRODUCTDESCR " + adv.getPrdesc()
                                        + "\n"+"\t"+"\t"+"TOTALCOST " + adv.getTotalcost()
                                        + "\n"+"\t"+"\t"+"SECPRICE " + ((RadioAdv) adv).getPrice()
                                        + "\n"+"\t"+"\t"+"SECDURATION " + ((RadioAdv) adv).getSecduration()
                                        + "\n"+"\t"+"\t"+"TIMEZONE " + ((RadioAdv) adv).getTimezone()
										+ "\n"+"\t"+"}");
						}//radio adv
						else if (adv instanceof WebAdv) {
								writer1.write ("\n"+"\t"+"ADVTYPE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"TYPE "+ adv.getType()
										+ "\n"+"\t"+"\t"+"ADVTYPE_CODE " + adv.getAdcode()
										+ "\n"+"\t"+"\t"+"DESCR " + adv.getAddesc()
										+ "\n"+"\t"+"\t"+"AFM "	+ adv.getTaxid()
										+ "\n"+"\t"+"\t"+"COMPANY " + adv.getBrand()
                                        + "\n"+"\t"+"\t"+"DURATION " + adv.getDuration()
                                        + "\n"+"\t"+"\t"+"DETAILS " + adv.getDetails()
                                        + "\n"+"\t"+"\t"+"ITEM_CODE " + adv.getProduct()
                                        + "\n"+"\t"+"\t"+"SUPPLIER " + adv.getSupplier()
                                        + "\n"+"\t"+"\t"+"PRODUCTDESCR " + adv.getPrdesc()
                                        + "\n"+"\t"+"\t"+"TOTALCOST " + adv.getTotalcost()
                                        + "\n"+"\t"+"\t"+"DAYPRICE " + ((WebAdv) adv).getPrice()
                                        + "\n"+"\t"+"\t"+"AUTOCOST " + ((WebAdv) adv).getAutocost()
                                        + "\n"+"\t"+"\t"+"EXTRACOST " + ((WebAdv) adv).getExtracost()
                                        + "\n"+"\t"+"\t"+"AUTO " + ((WebAdv) adv).getAuto()
                                        + "\n"+"\t"+"\t"+"EXTRAPAGES " + ((WebAdv) adv).getExtrapages()
										+ "\n"+"\t"+"}");
						}//web adv
                    }
                    writer1.write("\n"+"}");
                    writer1.close();    
                    writer2 = new FileWriter(new File("AdTypes.txt"));
                    writer2.write("ADVTYPE_LIST"+"\n"+"{");
                    for(AdType adtp: Adtypes.values()){
                        writer2.write ("\n"+"\t"+"ADVTYPE"+"\n"+"\t"+"{"+"\n"+"\t"+"\t"+"ADCODE "+ adtp.getAdcode()
                                + "\n"+"\t"+"\t"+"DESCR " + adtp.getAddesc()
                                + "\n"+"\t"+"}");
                    }//adtype 
                    writer2.write("\n"+"}");
                    writer2.close();
				}//try
					
			    catch (IOException e) {
					System.err.println("Error writing file.");
				}

                if(answer == 0){
                    in.close();
                    break;
                }    	
			}
            else if(answer == 1){
                System.out.println();
                System.out.println("--------------- ENTER CARRIER --------------");
                System.out.println();

                System.out.print("Enter Tax ID of the carrier: ");
                taxid = in.nextInt();
                System.out.print("Enter Brand's name : ");
                in.nextLine();
                brand = in.nextLine();

                Companies comp1 = new Companies(taxid, brand);
                Carriers.put(taxid, comp1);
  
            }
            else if(answer == 2){
                System.out.println();
                System.out.println("---------------- ENTER TYPE ---------------");
                System.out.println();


                System.out.print("Enter the Advertisement's code :");
                adcode = in.nextInt();

                in.nextLine();

                System.out.print("Enter the Advertisement's description :");
                addesc = in.nextLine();

                AdType adt1 = new AdType(adcode, addesc);
                Adtypes.put(adcode, adt1);

            }
            else if (answer == 3){
                System.out.println();
                System.out.println("---------------- ENTER ADVERTISEMENT ----------------");
                System.out.println();

                System.out.println("1) Printed Advertisement");
                System.out.println("2) Radio/TV Advertisement");
                System.out.println("3) Web Advertisement");
                System.out.print("Choose an option: ");
                type = in.nextInt();

                System.out.println();
                System.out.print("Enter the Advertisement's code :");
                adcode = in.nextInt();

                in.nextLine();

                System.out.print("Enter the Advertisement's description :");
                addesc = in.nextLine();




                System.out.println("--------------------------------------------");

                j = 0;
                for(Product products : Products.values()){
                    System.out.println(j + ") " + products);
                    j++;
                }

                System.out.print("Choose an Existing Product (1) or Add a new Product (2): ");
                option = in.nextInt();

                if (option == 1){
                    System.out.println();
                    System.out.print("Choose a Product from a List Above: ");
                    int ans = in.nextInt();

                    int key2 = productlist.get(ans);
                    product = Products.get(key2).getProduct();
                    supplier = Products.get(key2).getSupplier();
                    prdesc = Products.get(key2).getPrdesc();
                }
                else{
                    System.out.println();
                    System.out.print("Enter The Product's code: ");
                    product = in.nextInt();

                    in.nextLine();

                    System.out.println();
                    System.out.print("Enter The Supplier's ID: ");
                    supplier = in.nextInt();

                    in.nextLine();

                    System.out.println();
                    System.out.print("Enter the Products Description: ");
                    prdesc = in.nextLine();
                }


                System.out.println("--------------------------------------------");

                j = 0;
                for(Companies company : Carriers.values()){
                    System.out.println(j + ") " + company);
                    j++;
                }

                System.out.print("Select an Existing Company (1) or Add a new one (2): ");
                option = in.nextInt();

                if(option == 1){

                    System.out.println();
                    System.out.print("Choose a Company from a List Above: ");
                    int ans = in.nextInt();

                    int key3 = companylist.get(ans);
                    brand = Carriers.get(key3).getName();
                    taxid = Carriers.get(key3).getTaxid();
                }
                else{
                    System.out.println();
                    System.out.print("Enter The Companies Brand Name: ");
                    brand = in.nextLine();

                    in.nextLine();

                    System.out.println();
                    System.out.print("Enter The Companie's ID: ");
                    taxid = in.nextInt();
  
                }

                System.out.println("--------------------------------------------");

                System.out.print("Enter The Advertisement's Duration (in days): ");
                duration = in.nextInt();
                System.out.println();
                in.nextLine();

                System.out.print("Enter The Advertisement's Details: ");
                details = in.nextLine();

                if (type == 1){
                    System.out.print("Enter Word Count: ");
                    wordcount = in.nextInt();

                    System.out.println();
                    System.out.println("Listing Position");
                    System.out.println("1) Front Page");
                    System.out.println("2) Middle Page");
                    System.out.println("3) Last Page");
                    System.out.println();
                    System.out.print("Select an number from 1-3: ");
                    listingpos = in.nextInt();

                    System.out.println();
                    System.out.print("Enter the Price per Word: ");
                    pageprice = in.nextFloat();

                    PrintedAdv advertisement1 = new PrintedAdv(adcode, addesc, taxid, brand, type, duration, details, product, supplier, prdesc, wordcount, pageprice, listingpos,totalcost);
                    advertisement1.setTotalcost(advertisement1.getTotalcost());
                    Ads.put(adcode, advertisement1);

                }

                else if(type==2){
                    System.out.println();
                    System.out.print("Enter the duration of the Advertisement in seconds: ");
                    secduration = in.nextInt();

                    System.out.println();
                    System.out.println("Timezones: ");
                    System.out.println("1) Morning Zone");
                    System.out.println("2) Noon Zone");
                    System.out.println("3) Afternoon Zone");
                    System.out.println("4) Night Zone");
                    System.out.println();
                    System.out.print("Select a number from 1-4: ");
                    timezone = in.nextInt();

                    System.out.println();
                    System.out.print("Enter the price per second of the selected timezone: ");
                    radioprice = in.nextFloat();

                    RadioAdv advertisement2 = new RadioAdv(adcode, addesc, taxid, brand, type, duration, details, product, supplier, prdesc, radioprice, secduration, timezone, totalcost);
                    advertisement2.setTotalcost(advertisement2.getTotalcost());
                    Ads.put(adcode, advertisement2);

                }
                else if (type == 3){

                    System.out.println();
                    System.out.println("Enter Price per Day: ");
                    webprice = in.nextFloat();

                    System.out.println();
                    System.out.println("0) Without Automatic Appearance");
                    System.out.println("1) With Automatic Appearance");
                    System.out.print("Choose your option: ");
                    System.out.println();
                    auto = in.nextInt();

                    autocost = 0;
                    if (auto == 1){
                        System.out.print("Enter the Automatic Appearance price: ");
                        autocost = in.nextFloat();
                    }

                    System.out.println("Enter a number of extra pages for your Advertisement to show (0 for none): ");
                    extrapages = in.nextInt();
 
                    extracost = 0;
                    if (extrapages > 0){
                        System.out.print("Enter price for each extra page: ");
                        extracost = in.nextFloat()* extrapages;
                    }

                    WebAdv advertisement3 = new WebAdv(adcode, addesc, taxid, brand, type, duration, details, product, supplier, prdesc, webprice, autocost, extracost, auto, extrapages, totalcost);
                    advertisement3.setTotalcost(advertisement3.getTotalcost());
                    Ads.put(adcode, advertisement3);

                }                
                
            }
            else if (answer == 4){

                System.out.println();
                System.out.println("------------------ ADVERTISEMENTS ------------------");
                for(Advertisement ad : Ads.values()){
                    System.out.println(ad);
                    System.out.println();
                }
        
            }
            else if(answer == 5){
                j = 0;
                for(Companies company : Carriers.values()){
                    System.out.println(j + ") " + company);
                    j++;
                }

                System.out.println();
                System.out.print("Select an option: ");
                option = in.nextInt();
                in.nextLine();

                
                System.out.println();
                System.out.println("Company's Ads: ");
                System.out.println();

                int key4 = companylist.get(option);
                taxid = Carriers.get(key4).getTaxid();

                boolean flag=false;
                for(Advertisement ad : Ads.values()){
                    if(ad.getTaxid() == taxid){
                        flag = true;
                        System.out.println(ad);
                    }
                }
                if (flag == false){
                    System.out.println("None...");
                }
            }

            else if(answer==6){

                System.out.println("------------------ COST CALCULATION ------------------");
                
                j = 0;
                for(Companies company : Carriers.values()){
                    System.out.println(j + ") " + company);
                    j++;
                }

                System.out.println();
                System.out.print("Select an option: ");
                option = in.nextInt();
                in.nextLine();

                System.out.println();
                System.out.println("Company's Ads: ");
                System.out.println();

                int key4 = companylist.get(option);
                taxid = Carriers.get(key4).getTaxid();

                boolean flag=false;
                for(Advertisement ad : Ads.values()){
                    if(ad.getTaxid() == taxid){
                        flag = true;
                        System.out.println(ad);
                    }
                }
                if (flag == false){
                    System.out.println("None...");
                }

                cost=0;
                for(Advertisement ad : Ads.values()){
                    if(ad.getTaxid() == taxid){
                        cost += ad.getTotalcost();
                    }
                }
                System.out.println();
                System.out.println("The Company's Total Cost: " + cost);
                System.out.println();
            }
            else if(answer == 7){

                for(Advertisement ad : Ads.values()){
                    if(!Plurality.containsKey(ad.getProduct())){
                        Plurality.put(ad.getProduct(), 1);
                    }
                    else{
                        Plurality.put(ad.getProduct(), Plurality.get(ad.getProduct())+1);
                    }
                }

                ArrayList<Integer> valuesList = new ArrayList<Integer>();
                ArrayList<Integer> keysList = new ArrayList<Integer>();

                for(Integer plur : Plurality.keySet()){
                    keysList.add(plur);
                    valuesList.add(Plurality.get(plur));
                }

                int temp;
                for (int i = 0; i < valuesList.size(); i++) {
                    for (int z = valuesList.size() - 1; z > i; z--) {
                      if (valuesList.get(i) < valuesList.get(z)) {

                        temp = valuesList.get(i);
                        valuesList.set(i,valuesList.get(z));
                        valuesList.set(z, temp);

                        temp = keysList.get(i);
                        keysList.set(i,keysList.get(z));
                        keysList.set(z, temp);
                      }
                    }
                }

                for (int i = 0; i < valuesList.size(); i++) {
                    System.out.println( "The Product's code: " + keysList.get(i) + " The Number of Ads: " + valuesList.get(i));
                }

                Plurality.clear();
                keysList.clear();
                valuesList.clear();
            }

            else if(answer == 8){
                System.out.println();
                System.out.println("------------------ COST OF PRODUCT ------------------");
                System.out.println();

                j = 0;
                for(Product prod : Products.values()){
                    System.out.println(j + ") " + prod);
                    j++;
                }
                System.out.println();
                System.out.print("Select an option: ");
                option = in.nextInt();
                in.nextLine();

                int key5 = productlist.get(option);
                product = Products.get(key5).getProduct();

                cost=0;
                for(Advertisement ad : Ads.values()){
                    if(ad.getProduct() == product){
                        cost += ad.getTotalcost();
                    }
                }
                System.out.println();
                System.out.println("The Product's Total Cost: " + cost);
                System.out.println();
            }
            else if(answer==9){

                System.out.println();
                System.out.println("------------------ COSTS PER PRODUCT ------------------");
                System.out.println();

                for(Advertisement ad : Ads.values()){
                    if(!ProductSum.containsKey(ad.getProduct())){
                        ProductSum.put(ad.getProduct(), ad.getTotalcost());
                    }
                    else{
                        ProductSum.put(ad.getProduct(), ProductSum.get(ad.getProduct()) + ad.getTotalcost());
                    }
                }

                ArrayList<Float> CostsList = new ArrayList<Float>();
                ArrayList<Integer> CodesList = new ArrayList<Integer>();

                for(Integer sum : ProductSum.keySet()){
                    CodesList.add(sum);
                    CostsList.add(ProductSum.get(sum));
                }

                float temp1;
                int temp2;
                for (int i = 0; i < CostsList.size(); i++) {
                    for (int z = CostsList.size() - 1; z > i; z--) {
                      if (CostsList.get(i) < CostsList.get(z)) {

                        temp1 = CostsList.get(i);
                        CostsList.set(i,CostsList.get(z));
                        CostsList.set(z, temp1);

                        temp2 = CodesList.get(i);
                        CodesList.set(i,CodesList.get(z));
                        CodesList.set(z, temp2);
                      }
                    }
                }

                for (int i = 0; i < CostsList.size(); i++) {
                    System.out.println( "The Product's code: " + CodesList.get(i) + " The Total Cost: " + CostsList.get(i));
                }
                
                ProductSum.clear();
                CodesList.clear();
                CostsList.clear();
            }

            
        }
        in.close();
    }
}