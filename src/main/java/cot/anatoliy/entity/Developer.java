package cot.anatoliy.entity;

public class Developer {
    private int developerId;
    private String name;
    private int salary;
    private int departmentIdFk;

    public Developer(int developerId, String name, int salary, int departmentIdFk) {
        this.developerId = developerId;
        this.name = name;
        this.salary = salary;
        this.departmentIdFk = departmentIdFk;
    }

    public Developer(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Developer() {
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

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

    public int getDepartmentIdFk() {
        return departmentIdFk;
    }

    public void setDepartmentIdFk(int departmentIdFk) {
        this.departmentIdFk = departmentIdFk;
    }
}
