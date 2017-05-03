package view;

import controller.Controller;
import model.CreditCard;

/**
 * this class is a placeholder for the view.
 * @author Aldin
 */
public class View {
    
    private final Controller contr;
    private String regNumber;
    private CreditCard creditCard;
    
    /**
     * creates an instance that will use the controller for all system operations.
     * @param contr the controller which is used to run the system.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    /**
     * Executes the entire program
     */
    public void execution(){
        contr.newInspection();
        
        contr.closeDoor();
        
        String vehicleRegNumber = "ABC123"; 
        int cost = contr.enterVehicleNumber(vehicleRegNumber);
        System.out.println(cost);
        
        CreditCard creditCardInfo = creditCard;
        contr.cardPayment(creditCardInfo);
        
        contr.getInspection();
        
        boolean result = true;
        contr.enteredResult(result);
    }
    
}
