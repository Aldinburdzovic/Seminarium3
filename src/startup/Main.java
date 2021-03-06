
package startup;

import controller.Controller;
import integration.DatabaseManager;
import view.View;

/**
 * starts the application
 * @author Aldin
 */
public class Main {
    /**
     * this is the main method of the applications which starts the entire system.
     * @param args 
     */
    public static void main(String[] args) {
        DatabaseManager dbMgr = new DatabaseManager();
        Controller contr = new Controller(dbMgr);
        View view = new View(contr);
        view.execution();
       
        
        
    }
}
