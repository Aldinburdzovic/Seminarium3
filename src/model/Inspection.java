
package model;

import integration.SpecifiedInspection;

/**
 * this class represents the inspection of a vehicle
 * @author Aldin
 */
public class Inspection {
    private final SpecifiedInspection[] inspections;
    private final String regNumber;
    
    
    /**
     * creates an instance of the object inspection
     * @param regNumber registration number of the vehicle
     * @param inspections the inspections to be performed for the specific vehicle
     */
    public Inspection(String regNumber, SpecifiedInspection[] inspections){
        this.regNumber = regNumber;
        this.inspections = inspections; 
        
    }
   /**
    * return the total cost for the inspection
    * @return total cost of inspection
    */
    public int getCost(){
        int totalCost = 0;
        for(SpecifiedInspection specInsp : inspections){
        totalCost = totalCost + specInsp.getCost();                   
   }
       
        
        return totalCost;
    }
 
    
}
