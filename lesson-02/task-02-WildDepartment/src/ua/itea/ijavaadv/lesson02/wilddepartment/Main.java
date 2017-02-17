//D
package ua.itea.ijavaadv.lesson02.wilddepartment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created
 * at 14:19
 * on 06.02.17
 * by Iurii Derevianko;
 */
public class Main {
    public static void main(String[] args) {

        Employee[] employees = {
              new Employee("Aaa", 23),
              new Employee("Bbb", 24),
              new Employee("Ccc", 25),
              new Employee("Ddd", 26),
              new Employee("Eee", 27)
        };

        System.out.println(Arrays.toString(employees));
        System.out.println();

        List<Integer> listDepartment = new ArrayList<>();
        for (int i = 0; i < employees.length ; i++) {
            listDepartment.add(employees[i].getAge());
        }

        Department department = new Department(listDepartment, "Developers");
        Department anotherDepartmet = new Department(new ArrayList<>(), "Managers");

        System.out.println(department.getName() + " average age is " + department.averageAge() + ";");
        System.out.println(anotherDepartmet.getName() + " average age is " + anotherDepartmet.averageAge() + ";");
        System.out.println(department.getName() + " average age is same " + anotherDepartmet.getName() +
                 " average age: " + department.hasSameAverageAge(anotherDepartmet) + ";");
    }
}
