//D
package ua.itea.ijavaadv.lesson02.wilddepartment;

import ua.itea.ijavaadv.lesson02.dynamicarray.DynamicArray;
import java.util.List;

/**
 * Created
 * at 16:14
 * on 06.02.17
 * by Iurii Derevianko;
 */

public class Department extends DynamicArray<Integer> {
    private String name;

    public Department(List list, String name) {
        super(list);
        this.name = name;
    }

    double averageAge() {
        Double sum = 0.0;
        for (int i = 0; i < list.size() ; i++) {
            sum += list.get(i).doubleValue();
        }
        Double average = sum/list.size();
        return average;
    }

    boolean hasSameAverageAge(Department department){
        return this.averageAge() == department.averageAge();
    }

    public String getName() {
        return name;
    }
}
