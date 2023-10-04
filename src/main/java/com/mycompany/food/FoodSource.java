
package com.mycompany.food;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ourie
 */
public class FoodSource {
    public Document document;
    public String[][] weekFoodData;
    public String[] foodData;
    public void getSauce(){
        String url = "https://www.mbfood.cz/restaurace/prague-gate/tydenni-menu/";
        
        try {
            document = Jsoup.connect(url).get();
            //System.out.println(document);
            
        } catch (IOException ex) {
            Logger.getLogger(Food.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String[][] getFood(){
        Elements tables = document.select("table");
        
        weekFoodData = new String[tables.size()][];
        for (int i=0; i < weekFoodData.length; i++){
            //System.out.println(tables.get(i));
            //tables.get(i);
            //weekFoodData[i];
            Elements rows = tables.get(i).select("tr.day-menu-td");
            foodData = new String[rows.size()];
           
            weekFoodData[i] = new String[rows.size()];
            for (int j = 0; j < rows.size(); j++) {
                Element row = rows.get(j);
                Elements cols = row.select("td");

                String number = cols.get(0).text();
                String dish = cols.get(1).text();
                String price = cols.get(2).text();

                String rowData = dish + ", Cena: " + price;
                //System.out.println(rowData);
                //System.out.println("i: "+i);
                //System.out.println("j: "+j);
                //System.out.println(rows.size());
                foodData[j] = rowData; // Add the row data to the array
                weekFoodData[i][j] = foodData[j];
                
                
            }
            
             
            
            
        }
        return weekFoodData;
    }
}
