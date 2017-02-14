package ua.itea.ijavaadv.lesson01.format;
import java.util.Date;
import java.util.Formattable;
import java.util.Formatter;


public class Person implements Formattable {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected boolean gender;
    protected Date birth;
    protected Temperament temperament;
    protected PhoneNumber number;
    protected Object [] args = {firstName, lastName, age, gender, birth, temperament, number};

    enum PersonFormat {
        SHORT ("%1$s %2$s, %7$s;%n"),
        MEDIUM ("%1$s %2$s, %5$td.%5$tm.%5$ty, %3$d years, %7$s;%n"),
        LONG ("%1$s %2$s, %5$td.%5$tm.%5$ty, %3$d years, %4$b, %6$s, %7$s;%n");

        private final String mood;

        PersonFormat(String mood) {
            this.mood = mood;
        }

        public String mood() {
            return mood;
        }
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%1$s %2$s, %5$td.%5$tm.%5$ty, %3$d years, %4$b, %6$s, %7$s;%n", args);
    }


    public Object [] getArgs() {
        return args;
    }

    public Person() {
    }

    public Person(String firstName, String lastName, int age, boolean gender, Date birth, Temperament temperament, PhoneNumber number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birth = birth;
        this.temperament = temperament;
        this.number = number;

        args[0] = firstName;
        args[1] = lastName;
        args[2] = age;
        args[3] = gender;
        args[4] = birth;
        args[5] = temperament;
        args[6] = number;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d, %b, %s, %s, %s\n", firstName, lastName, age, gender, birth, temperament, number);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isGender() {
        return gender;
    }

    public Temperament getTemperament() {
        return temperament;
    }
}