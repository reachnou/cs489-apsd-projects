package factory;

import entity.Employee;
import entity.PensionPlan;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeFactory {
    private static final List<Employee> data = new ArrayList<>();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void init() {
        PensionPlan pensionPlan1 = new PensionPlan(1089L, "2023-01-17", 100.00);
        PensionPlan pensionPlan2 = new PensionPlan(2307L, "2019-11-04", 1555.50);

        Employee employee1 = new Employee(1L, "Daniel", "Agar", "2018-01-17", 105945.50, pensionPlan1);
        Employee employee2 = new Employee(2L, "Benard", "Shaw", "2019-04-03", 197750.00, null);
        Employee employee3 = new Employee(3L, "Carly", "Agar", "2014-05-16", 842000.75 , pensionPlan2);
        Employee employee4 = new Employee(4L, "Wesley", "Schneider", "2019-05-02", 74500.00, null);

        data.add(employee1);
        data.add(employee2);
        data.add(employee3);
        data.add(employee4);
    }

    public static void printEmployeesAscByLastNameAndDscByYearlySalariesAsJSON() {
        data.sort(Comparator
                .comparing(Employee::getLastName)
                .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()));

        printJSONFormat(data);
    }

    public static void printEmployeesWhoQualifyForMonthlyUpcomingPensionEnrollsReportAsJSON() {
        List<Employee> qualifiedEmployee = new ArrayList<>(data.stream()
                .filter(EmployeeFactory::isqQualifyForPension)
                .toList());

        qualifiedEmployee.sort(Comparator.comparing(Employee::getEmploymentDate));

        printJSONFormat(qualifiedEmployee);
    }

    public static void printJSONFormat(List<Employee> employees) {
        System.out.println("[");
        for (Employee employee : employees) {
            System.out.println("\t{");
            System.out.println("\t  \"employeeId\": " + employee.getEmployeeId() + ",");
            System.out.println("\t  \"firstName\": \"" + employee.getFirstName() + "\",");
            System.out.println("\t  \"lastName\": \"" + employee.getLastName() + "\",");
            System.out.println("\t  \"employmentDate\": \"" + dateFormat.format(employee.getEmploymentDate()) + "\",");
            System.out.println("\t  \"yearlySalary\": \"" + employee.getYearlySalary() + ",");
            System.out.println("\t  \"pensionPlan\": " + employee.getPensionPlan());
            System.out.println("\t}");
        }
        System.out.println("]");
    }

    public static boolean isqQualifyForPension(Employee employee) {
        int employmentDuration = calculateEmploymentDuration(employee);
        return employee.getPensionPlan() == null && employmentDuration >= 5;
    }

    public static int calculateEmploymentDuration(Employee employee) {
        LocalDate today = LocalDate.now();
        LocalDate endOfNextMonth = today.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        LocalDate startDate = employee.getEmploymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period duration = Period.between(startDate, endOfNextMonth);
        return duration.getYears();
    }
}
