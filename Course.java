/* Assignment #: 4
 Name: Jordan Ledbetter
 StudentID: 1222370253
 Lecture: T/Th 10:30am
Description: The Course class describes information for a course, 
including course ID, the instructor, and the subject. Returning course
information as in the classes' toString method.
 */

public class Course {
    // declare instance variables
    private int courseId;
    private String instructor;
    private  String subject;

    // constructor method for child class Course
    public Course() {
        // initialize instance variables
        courseId = 0;
        instructor = "?";
        subject = "?";
    }

     // second constructor method with set parameters
     public Course(int courseId, String instructor, String subject) {
        // assign parameters to the same value as the class attributes
        this.courseId = courseId;
        this.instructor = instructor;
        this.subject = subject;
    }

    // create a getCourseId() method to return the course ID
    public int getCourseId() {
        return courseId;
    }

    // create a getInstructor() method to return the instructor
    public String getInstructor() {
        return instructor;
    }

    // create a getSubject() method to return the subject
    public String getSubject() {
        return subject;
    }

    // create a setCourseId() method to assign the value of the class attribute to the parameter
    public void setCourseId(int someCourseId) {
        courseId = someCourseId;
    }

    // create a setInstructor() method to assign the value of the class attribute to the parameter
    public void setInstructor(String someInstructor) {
        instructor = someInstructor;

    }

    // create a setSubject() method to assign the value of the class attribute to the parameter
    public void setSubject(String someSubject) {
        subject = someSubject;
    }

    // create a toString() method to return the Course information
    public String toString() {
        return "\nCourse information:" +
        "\nCourse ID:\t" + courseId +
        "\nInstructor:\t" + instructor +
        "\nSubject:\t" + subject +"\n";
    }

}