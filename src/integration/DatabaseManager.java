
package integration;

import java.util.ArrayList;
import java.util.List;
/**
 * this class makes all the calls to the database
 * @author Aldin
 */

public class DatabaseManager {
    private SpecifiedInspection[] inspections;
    private List results;
    
    /**
     * creates a new instance.
     * Uses hardcoded array of inspections insted of calling database
     */
    public DatabaseManager(){
        createInspections();
    }
    /**
     * A call for an array of the inspections to be made. 
     * This return hardcoded inspections if the registration number of the vehicel is ABC123. 
     * @param regNumber registraion number of the vehicle to inspect
     * @return An array of inspections.
     */
    public SpecifiedInspection[] findInspectionsByVehicle(String regNumber){
        if(regNumber.equals("ABC123")){
            return inspections;
        }
        
        return inspections;
    }
   /**
    * creates the hardcoded dummy inspections 
    */
    private void createInspections(){
        inspections = new SpecifiedInspection[3];
        inspections[0] = (new SpecifiedInspection("brakes", 50));
        inspections[1] = (new SpecifiedInspection("lights", 40));
        inspections[2] = (new SpecifiedInspection("stearing", 60));
    }
    /**
     * creates an arraylist with the results of the specified inspections.
     * @param result the result of the specific inspection, pass or fail.
     */
    public void createResults(boolean result){
        results = new ArrayList();
        results.add(result);
        
    }
}
