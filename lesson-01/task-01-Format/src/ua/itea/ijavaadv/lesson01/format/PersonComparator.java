package ua.itea.ijavaadv.lesson01.format;
import java.util.Comparator;
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {


        if(o1.isGender() && !o2.isGender()) {
            return -1;
        }

        if(!o1.isGender() && o2.isGender()) {
            return 1;
        }


        if(o1.isGender() == o2.isGender() && o1.isGender()) {
            o1.getTemperament().compareTo(o2.getTemperament());
            if(o1.getTemperament().equals(o2.getTemperament())) {
                int flag = o1.getAge() - o2.getAge();
                if(flag ==0) {
                    flag = o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
                }
                if(flag ==0) {
                    flag = o1.getLastName().compareToIgnoreCase(o2.getLastName());
                }
                return flag;
            }
        }
        return 0;
    }
}
