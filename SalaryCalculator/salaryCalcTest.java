import java.util.Scanner;

public class salaryCalcTest {

    public static void main(String[] args) {

        //Creating 3 instances of employee class
        employee emp1 = new employee();
        //calling display method to print employee class
        emp1.Display();
        employee emp2 = new employee();
        emp2.Display();
        employee emp3 = new employee();
        emp3.Display();
    }
}

//Employee class begins here
class employee{

    //Fields for employee
    private String employeeName;
    private double empRate;
    private int hours;

    //Creating an object of Scanner class
    Scanner scanner = new Scanner(System.in);


    /*
    Employee constructor that prompts to input
    for employee class features when the object is initialized.
    */
    employee()
    {

        System.out.println("Enter Name of the Employee:");
        //prompts new line for each employee
        employeeName = scanner.nextLine();

        System.out.println("Enter Hourly Rate of the Employee:");
        //prompts hourly rate variable for each employee
        empRate = scanner.nextDouble();

        System.out.println("Enter Hours Per Week of the Employee:");
        //prompts employee hours of work for each
        hours = scanner.nextInt();

    }

    /*
    calculatePay method gets two parameters "hours and perHourPay"
    returns targeted pay depends on entered parameters
     */
    double calculatePay(int hours, double perHourPay){

        double pay = 0;
        double extraPay = perHourPay * 2.5;
        if (hours < 40){
            System.out.println("\nPlease Enter Your Work Hours Again");
            return 1;
        }
        //return 40 hours equavilent payment for each employee
        if (hours == 40){
            return hours * perHourPay;
        //calculate the payment for extra hours of work
        } else if (hours > 40){
            int extraHours = (hours - 40);
            pay = (40 * perHourPay) + (extraHours * extraPay);
        }
        //returns extra hours
            return pay;
    }
    void Display(){
        //Display the each employee's details and gross pay
        System.out.printf("Employee %S gets paid %f Per/Hour and works %d hours ",employeeName,empRate,hours);
        System.out.println("The gross pay is " + this.calculatePay(hours,empRate ));
        System.out.println();
    }

}
