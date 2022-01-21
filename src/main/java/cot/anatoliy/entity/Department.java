package cot.anatoliy.entity;

public class Department {
    private int departmentId;
    private String name;
    private String address;

    public Department(int departmentId, String name, String address) {
        this.departmentId = departmentId;
        this.name = name;
        this.address = address;
    }

    public Department(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Department() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
