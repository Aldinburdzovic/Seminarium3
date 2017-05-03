
package controller;

import integration.DatabaseManager;
import integration.DisplayNumber;
import integration.Garage;
import integration.SpecifiedInspection;
import java.util.List;
import model.CreditCard;
import model.Display;
import model.Inspection;
import model.Payment;
import model.PaymentAuthorization;

/** 
 * This is the application's only controller. All calls to the model pass through here.
 * @author Aldin
 */

public class Controller {
    
    private DisplayNumber displayNumber;
    private final Garage garage;
    private final DatabaseManager dbMgr; 
    private Inspection inspection;
    private final SpecifiedInspection[] inspections;
    private Payment payment;
    private CreditCard creditCard;
    
    /**
     * Creates a new instance of the object Controller.
     * @param dbMgr is the database manager used for all database calls.
     */
    
    public Controller(DatabaseManager dbMgr){     
        this.dbMgr = dbMgr;
        this.garage = new Garage();
        this.inspections = dbMgr.findInspectionsByVehicle("ABC123");
        this.inspection = new Inspection("ABC123", inspections);
    }
    /**
     * Starts a new inspection.
     * Displays the next queue number and opens the garage door.
     */
    public void newInspection(){
        int nextNumber = displayNumber.nextNumber();
        Display.displayNumber(nextNumber);
        garage.open();
    }
    /**
     * closes the garage door.
     */
    public void closeDoor(){
        garage.close();
    }
    /**
     * This method gets the cost for the specified inspection based on the registration number.
     * @param regNumber the registration number of the vehicle.
     * @return the cost for the specific inspection, or returns 0 if there are no inspections to perform.
     */
    public int enterVehicleNumber(String regNumber){
        SpecifiedInspection[] inspectionList = dbMgr.findInspectionsByVehicle(regNumber);
        this.inspection = new Inspection(regNumber, inspectionList);
        return inspection.getCost(); 
    }
    /**
     * This method does the payment of the inspection.
     * it sends an paymetn authorization with the credit card info and the cost, to an external system and gets an approval. 
     * In this case the approval will always return true/pass;
     * @param creditCard the credit card that pays for the inspection.
     */
    public void cardPayment(CreditCard creditCard){
        int cost = inspection.getCost();
        boolean paymentApproval = PaymentAuthorization.authorization(creditCard, cost);
        if(paymentApproval){
        Payment newPayment = new Payment(creditCard, 0); //kolla upp
        }
    }
    /**
     * This method gets the specific inspection to perform.
     * @return the inspection to be performed by the inspector.
     */
    public SpecifiedInspection getInspection(){
        int n = 0;
        SpecifiedInspection currentInsp = inspections[0];  //kolla upp
        n++;
        return currentInsp;
    }
    /**
     * the inspector enters the result of the specific inspection made.
     * @param result either true/pass or false/fail.
     */
    public void enteredResult(boolean result){
        dbMgr.createResults(result);
    }
}
