/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rc;

import java.util.InputMismatchException;
import static rc.Student.deleteStudent;
import static rc.Student.input;
import static rc.Student.saveStudent;
import static rc.Student.searchStudent;
import static rc.Student.studentReport;

/**
 *
 * @author RC_Student_lab
 */
public class PROG6112_A1 {

    public static void main(String[] args) {
        displayMenu();
        }
        
    
        public static void displayMenu(){
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("*********************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
        int opt;
        try {
            opt = input.nextInt();
            input.nextLine();
        }catch(InputMismatchException e) {
            System.out.println("Exiting...");
            return;
        }
        
        if (opt == 1) {
            while(true) {
                System.out.println("Please select the following menu items:");
                System.out.println("(1) Capture a new student");
                System.out.println("(2) Search for a student");
                System.out.println("(3) Delete a student");
                System.out.println("(4) Print student report");
                System.out.println("(5) Exiting application");
                
                int menu = input.nextInt();
                input.nextLine();
                
                switch (menu) {
                    case 1:
                        saveStudent();
                        break;
                                
                    case 2:
                        searchStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        studentReport();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Please enter one of the numbers, please try again");
                        break;
                }
            }
        } else {
            System.out.println("Exiting the application");
        }
        }
}
    

