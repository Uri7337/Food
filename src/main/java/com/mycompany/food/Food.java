
package com.mycompany.food;

public class Food {

    public static void main(String[] args) {
        FoodSource fs = new FoodSource();
        fs.getSauce();
        
        FoodFrame ff = new FoodFrame(fs.getFood());
        ff.setVisible(true);
        
    }
}
