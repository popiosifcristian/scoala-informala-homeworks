/**
 * @author Pop Iosif Cristian
 */
public class Main {
    public static void main(String[] args){
        //we create a new Company
        Company company = new Company();
        //we create a new CompanyManager
        CompanyManager companyManager = new CompanyManager();

        //we add Employees
        companyManager.addEmployee("Pop Iosif",0,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Andrei Sipos",2,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Andrei Lazurca",5,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Rares Scarlat",1,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("William Oanta",6,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("James Oanta",3,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Andrei Hegedus",8,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Alexandru Huzdup",7,"junior",company.employees,company.withoutParkingSpace,company.managers,company.juniors);
        companyManager.addEmployee("Sebastian Presecan",15,"manager",company.employees,company.withoutParkingSpace,company.managers,company.juniors);

        System.out.println('\n'+"Company Employees List"+'\n'+company.employees);
        companyManager.sortAListBySeniority(company.employees);
        System.out.println('\n'+"Company Employees List Sorted By Seniority"+'\n'+company.employees);
        System.out.println('\n'+"Company Employees Without Parking Space List"+'\n'+company.withoutParkingSpace);
        System.out.println('\n'+"Company Employees Juniors List"+'\n'+company.juniors);
        System.out.println('\n'+"Company Employees Managers List"+'\n'+company.managers);
    }
}
