//Module6JavaIVAssignmentDay20

import java.util.Arrays;
import java.util.List;

public class AbstractHumanClass {
    public static void main(String[] args) {
        List<String> studentCourses = Arrays.asList("Math", "Science", "English");
        Human student = new Student("John Doe", "S001", 10, studentCourses);
        student.printDetails();
        student.printResponsibilities();

        List<String> teacherCourses = Arrays.asList("Math", "Physics");
        Human teacher = new Teacher("Jane Smith", "T001", "Mathematics", teacherCourses);
        teacher.printDetails();
        teacher.printResponsibilities();

        Human principal = new Principal("Sophia Okito");
        principal.printDetails();
        principal.printResponsibilities();
    }
}

abstract class Human {
    private String name;
    private Role role;

    public enum Role {
        Student, Teacher, Principal
    }

    public Human(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public abstract void printResponsibilities();

    public void printDetails() {
        System.out.println("My name is " + name + ". I am a " + role + ".");
    }
}

class Student extends Human {
    private String studentId;
    private int grade;
    private List<String> courses;

    public Student(String name, String studentId, int grade, List<String> courses) {
        super(name, Role.Student);
        this.studentId = studentId;
        this.grade = grade;
        this.courses = courses;
    }

    @Override
    public void printResponsibilities() {
        System.out.println("As a student, my responsibilities are to attend classes, complete assignments, and study.");
        System.out.println("Student ID: " + studentId);
        System.out.println("Grade: " + grade);
        System.out.println("Courses: " + String.join(", ", courses));
    }
}

class Teacher extends Human {
    private String teacherId;
    private String subject;
    private List<String> courses;

    public Teacher(String name, String teacherId, String subject, List<String> courses) {
        super(name, Role.Teacher);
        this.teacherId = teacherId;
        this.subject = subject;
        this.courses = courses;
    }

    @Override
    public void printResponsibilities() {
        System.out.println("As a teacher, my responsibilities are to prepare lesson plans, teach classes, and grade assignments.");
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Subject: " + subject);
        System.out.println("Courses: " + String.join(", ", courses));
    }
}

class Principal extends Human {
    public Principal(String name) {
        super(name, Role.Principal);
    }

    @Override
    public void printResponsibilities() {
        System.out.println("As a Principal, my responsibilities are to oversee the affairs of the school and student welfare.");
    }
}
