package HTTPJSONDemo;

import static Util.Util.abbreviateString;

public class Employee {
    int getId() {
        return id;
    }

    private int id;

    @Override
    public String toString() {
        return "Info for employee: " +
                "id=" + id +
                ", employee_name='" + employee_name + '\'' +
                ", employee_salary=" + employee_salary +
                ", age=" + age;
    }

    String toStringShort() {
        return String.format("%15s\t\t",abbreviateString(employee_name,15));
    }

    private String employee_name;
    private double employee_salary;
    private int age;
    private String profile_image;

}

