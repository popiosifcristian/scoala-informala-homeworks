import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**This is the Company Manager class, this class will help us to manage the company
 * @author Pop Iosif Cristian
 */
public class CompanyManager {
    /**
     * This method will add Employees to the company
     * @param name name of the employee
     * @param yearsInCompany years of the employee in the company
     * @param role role of the employee
     * @param employees a list from the company that contains employees
     * @param withoutParkingSpace a list from the company that contains employees without parking space
     * @param managers a list from the company that contains managers
     * @param juniors a list from the company that contains juniors
     */
    public void addEmployee(String name, int yearsInCompany, String role, List employees, List withoutParkingSpace, List managers, List juniors) {
        Employee employee= new Employee(name,yearsInCompany,role);
        employees.add(employee);

        //We will set the seniority as true if the
        //Employee has more than 2 years worked in the company
        // If the Employee is a Senior than he have parking space
        if (employee.getYearsInCompany() > 2) {
            employee.setSeniority(true);
            employee.setParkingSpace(true);
        }

        //if the employee have no parking space we will add him in list of employees without parking space
        if(employee.isParkingSpace()==false) {
            withoutParkingSpace.add(employee);
        }
        //if the employee have the manager role, he will be added to managers list
        if(employee.getRole().equals("manager"))
            managers.add(employee);
        //if the employee have the junior role, he will be added to juniours list
        if(employee.getRole().equals("junior"))
            juniors.add(employee);

    }
    /**
     * Here we have the comparator that will help us sort
     * the lists by seniority
     */
    static class SeniorityComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1,Employee o2) {
            if(o1.getYearsInCompany()==o2.getYearsInCompany())
                return 0;
            if(o1.getYearsInCompany()<o2.getYearsInCompany())
                return 1;
            return -1;
        }
    }

    /**
     * this method will sort a list by seniority
     * @param list will be sorted by seniority
     */
    public void sortAListBySeniority (List list){
        Collections.sort(list,new SeniorityComparator());
    }
}
