import java.util.*;

class prog {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        long employeeNumber = 0;
        String employeeName;
        double hourlySalary = 0.00;
        double weeklyTime = 0.00;
        double regularTime, overtime;
        double regularPay, overtimePay, netPay;

        try {
            System.out.print("Enter Employee Number (00000): ");
            employeeNumber = scnr.nextLong();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong Employee Number!");
            return ;
        }
        if (employeeNumber == 82500)
            employeeName = "Peter Baker";
        else if (employeeNumber == 92746)
            employeeName = "John Kouma";
        else if (employeeNumber == 54080)
            employeeName = "Steg Larson";
        else if (employeeNumber == 86285)
            employeeName = "Gertrude Monay";
        else
            employeeName = "Unknown";

        try {
            System.out.print("Enter Hourly Salary: ");
            hourlySalary = scnr.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println();
            System.out.println("The Hourly Salary must be double!");
            return ;
        }
        if(hourlySalary < 0) {
            System.out.println();
            System.out.println("The Hourly Salary must be positive!");
            return ;
        }
        try {
            System.out.print("Enter Weekly Time: ");
            weeklyTime = scnr.nextDouble();
        }

        catch(InputMismatchException e) {
            System.out.println("The Weekly Time must be double!");
            return ;
        }


        if (weeklyTime < 40) {
            regularTime = weeklyTime;
            overtime = 0;
            regularPay = hourlySalary * regularTime;
            overtimePay = 0;
            netPay = regularPay;
        } else {
            regularTime = 40;
            overtime = weeklyTime - 40;
            regularPay = hourlySalary * 40;
            overtimePay = hourlySalary * overtime;
            netPay = regularPay + overtimePay;
        }

        System.out.println("======================");
        System.out.println("==-=-= Employee Payroll =-=-==");
        System.out.println("-------------------------------------------");
        System.out.printf("Employee #:    %d\n", employeeNumber);
        System.out.printf("Employee Name: %s\n", employeeName);
        System.out.printf("Hourly Salary: %.2f\n", hourlySalary);
        System.out.printf("Weekly Time:   %.2f\n", weeklyTime);
        System.out.printf("Regular Pay:   %.2f\n", regularPay);
        System.out.printf("Overtime Pay:  %.2f\n", overtimePay);
        System.out.printf("Total Pay:     %.2f\n", netPay);
        System.out.println("======================");
    }
}

