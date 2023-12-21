package org.juzyz.common;

public class Employee {
    public Employee(String ename, int salary, int experience) {
        this.name = ename;
        this.salary = salary;
        this.experience = experience;;
    }

    public Employee(String name) {
        this.name = name;
        salary = 0;
    }

    String name;
    int salary;
    int experience;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


}
