package RealTimeExamples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class RealTimeExamples {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		
		//Query 3.1 : How many male and female employees are there in the organization?
		Map<String, Long> maleAndFemaleEmployee = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(maleAndFemaleEmployee);
		
		//Query 3.2 : Print the name of all departments in the organization?
		List<String> collect = employeeList.stream().map(Employee::getDepartment).collect(Collectors.toList());
		System.out.println(collect);
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		
		//Query 3.3 : What is the average age of male and female employees?
		Map<String, Double> avgAgeOfMaleFemaleEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("avgAgeOfMaleFemaleEmp="+avgAgeOfMaleFemaleEmp);
		
		//Query 3.4 : Get the details of highest paid employee in the organization?
		Employee employee = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(employee);
		Employee employee2 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get();
		System.out.println(employee2);
		
		//Query 3.5 : Get the names of all employees who have joined after 2015?
		List<String> joinedAfter2015 = employeeList.stream().filter(emp-> emp.getYearOfJoining() >= 2015).map(Employee::getName).collect(Collectors.toList());
		System.out.println(joinedAfter2015);
		System.out.println(joinedAfter2015.size());
		employeeList.stream().filter(emp-> emp.getYearOfJoining() > 2015).map(Employee::getName).distinct().forEach(System.out::println);
		
		//Query 3.6 : Count the number of employees in each department?
		Map<String, Long> employeeInEachDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(employeeInEachDept);
		Set<Entry<String, Long>> entrySet = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet();
		for(Map.Entry<String, Long> entry : entrySet) {
			if(entry.getValue() == 2) { //entry.getValue() > 2
				System.out.println(entry.getKey() +","+entry.getValue());
			}
		}
		
		//Query 3.7 : What is the average salary of each department?
		Set<Entry<String, Double>> eachDeptAvgSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))).entrySet();
		eachDeptAvgSalary.stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		Set<Entry<String, Double>> collect2 = eachDeptAvgSalary.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2)-> m1, LinkedHashMap::new)).entrySet();
		for(Map.Entry<String, Double> entry : collect2) {
			System.out.println(entry.getKey() +","+entry.getValue());
		}

		//Query 3.8 : Get the details of youngest male employee in the product development department?
		Employee yougestEmpl = employeeList.stream().filter(e-> e.getGender() == "Male" && e.getDepartment() =="Product Development").collect(Collectors.minBy(Comparator.comparing(Employee::getAge))).get();
		System.out.println(yougestEmpl);
		Optional<Employee> min = employeeList.stream().filter(em->em.getGender() =="Male" && em.getDepartment() =="Product Development").min(Comparator.comparing(Employee::getAge));
		System.out.println(min.get());
		
		//Query 3.9 : Who has the most working experience in the organization?
		Employee employee3 = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();
		System.out.println(employee3);
		
		Employee employee4 = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining))).get();
		System.out.println(employee4);
		
		//Query 3.10 : How many male and female employees are there in the sales and marketing team?
		Map<String, Long> salesDeptMaleFemaleEmp = employeeList.stream().filter(s->s.getDepartment() =="Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("salesDeptMaleFemaleEmp = " + salesDeptMaleFemaleEmp);
		
		//Query 3.11 : What is the average salary of male and female employees?
		Map<String,Double> salaryOfMaleFemaleEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(salaryOfMaleFemaleEmp);
		
		//Query 3.12 : List down the names of all employees in each department?
		Set<Entry<String, List<Employee>>> employeeInEachDepts = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment)).entrySet();
		for(Map.Entry<String, List<Employee>> entry : employeeInEachDepts) {
			System.out.println("==================================");
			System.out.println(entry.getKey());
			for(Employee emp : entry.getValue()) {
				System.out.println("------------------------------");
				System.out.println(emp);
			}
		}
		System.out.println("****************************************************************");
		Map<String,List<Employee>> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		collect3.entrySet().stream().forEach(emp-> {
			System.out.println("======");
			System.out.println(emp.getKey());
			System.out.println("------");
			emp.getValue().forEach(e->System.out.println(e.getName()));
		});
		
		//Query 3.13 : What is the average salary and total salary of the whole organization?
		DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(doubleSummaryStatistics.getAverage());
		System.out.println(doubleSummaryStatistics.getMax());
		System.out.println(doubleSummaryStatistics.getMin());
		System.out.println(doubleSummaryStatistics.getSum());
		
		//Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
		Set<Entry<Boolean, List<Employee>>> partitionByExample = employeeList.stream().collect(Collectors.partitioningBy(y->y.getAge() > 25)).entrySet();
		for(Map.Entry<Boolean, List<Employee>> entry : partitionByExample) {
			if(entry.getKey()) {
				System.out.println("------------older-----------");
				entry.getValue().stream().forEach(x->System.out.println(x.getName()));
			}else {
				System.out.println("------------younger-----------");
				entry.getValue().stream().forEach(x->System.out.println(x.getName()));
			}
		}
		
		//Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
		Employee employee5 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge))).get();
		System.out.println(employee5.getName());
		Employee employee6 = employeeList.stream().max(Comparator.comparing(Employee::getAge)).get();
		System.out.println(employee6.getName());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
