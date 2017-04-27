package view;

import controller.Controller;

public class View {
    
    private Controller contr;
    private String regNumber;
    
    
    public void beginInspection(){
        contr.newInspection();
    }
    public void closeDoor(){
        contr.closeDoor();
    }
    public void getCost(){
        String vehicleRegNumber = regNumber;
        int cost = contr.enterVehicleNumber(vehicleRegNumber);
        System.out.println(cost);
       
    }
}
