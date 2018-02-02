/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaron.model;

import java.io.Serializable;

/**
 *
 * @author glaucio
 */
public class ListItem implements Serializable{
    private String name;
    private int number;
       
   public ListItem(){
       
   }
    
   public ListItem(String name, int number){
       this.name = name;
       this.number = number;
   }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ListItem{" + "name=" + name + ", number=" + number + '}';
    }

}
