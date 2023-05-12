/* Assignment #: 4
 Name: Jordan Ledbetter
 StudentID: 1222370253
 Lecture: T/Th 10:30am
Description: The Student class will get the ID, major, and course corresponding to a student (who represents
a new object), and return their information as a string, along with the course information from the Course class.
 */

public class Student {
    // declare instance variables
    private int id;
    private String major;
    private Course course;

    // constructor method for child class Student
    public Student() {
        // initialize instance variables
        id = 0;
        major = "?";
        course = new Course();
    }

    // second constructor method with set parameters
    public Student(int id, String major, Course course) {
        // assign parameters to the same value as the class attributes
        this.id = id;
        this.major = major;
        this.course = course;

    }

    // create a getId() method to return a student's ID
    public int getId() {
        return id;
    }

    // create a getMajor() method to return a student's major
    public String getMajor() {
        return major;
    }

    // create a getCourse() method to return a student's major
    public Course getCourse() {
         return course;
    }

    // create a setId() method to assign the value of the class attribute to the parameter
    public void setId(int id) {
        this.id = id;
    }

    // create a setMajor() method to assign the value of the class attribute to the parameter
    public void setMajor(String major) {
        this.major = major;
    }

    // create a setCourse() method to assign the value of the class attribute to the parameter
    public void setCourse(Course course) {
        this.course = course;
    }

    // create a toString() method to return the Student information
    // in addition, call the toString method from the Course class
    public String toString() {
        return "\nStudent information:" +
        "\nStudent Id:\t" + id +
        "\nMajor:\t\t" + major + "\n" +
        course.toString();
        
    }

}