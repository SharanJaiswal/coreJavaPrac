package kk.maps;

/**
 * If this class would be used as key in hashmap. So, we have an option to override equals() method, and hence hashCode() method. equals() because in case of hash-collision for giving custom key comparison logic.
 * hashCode() because if in case of equals() override, we must override hashCode() as well to maintain the equals-hashCode mutual contract.
 * comapreTo() from Comparable<Student> can also be overridden in case when treefy happens, to place child nodes accordingly in RBtree|self-balancing tree.
 */

public class Student {
    String firstName;
    String lastName;
    int id;
    String department;

    public Student(String firstName, String lastName, int id, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
