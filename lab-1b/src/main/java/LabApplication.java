import factory.EmployeeFactory;

public class LabApplication {
    public static void main(String[] args) {

        EmployeeFactory.init();
        //Task B (1)
        System.out.println("========== Task B (1) ==========");
        EmployeeFactory.printEmployeesAscByLastNameAndDscByYearlySalariesAsJSON();
        //Task B (2)
        System.out.println("========== Task B (2) ==========");
        EmployeeFactory.printEmployeesWhoQualifyForMonthlyUpcomingPensionEnrollsReportAsJSON();
    }
}
