
package controller;

import integration.DisplayNumber;
import integration.Garage;
import model.Display;
import model.Inspection;

public class Controller {
    
    private DisplayNumber displayNumber;
    private Garage garage;
    
    public Controller(){
        
    }
    public void newInspection(){
        int nextNumber = displayNumber.nextNumber();
        Display.displayNumber(nextNumber);
        garage.open();
    }
    public void closeDoor(){
        garage.close();
    }
    
    public int enterVehicleNumber(String regNumber){
        
        
        return Inspection.getCost();
    }
}
