/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package rc;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class StudentIT {
    
    public StudentIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        // Clear the students list and add sample data before each test
        Student.addStudent(new Student(1, "John Doe", 20, "john.doe@example.com", "Computer Science"));
        Student.addStudent(new Student(2, "Jane Smith", 22, "jane.smith@example.com", "Mathematics"));
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of saveStudent method, of class Student.
     */
   @Test
    void testSaveStudent() {
        // Arrange
        int id = 1;
        String name = "John Doe";
        int age = 20;
        String email = "john.doe@example.com";
        String course = "Computer Science";

        // Act
        Student.saveStudent();
        List<Student> students =new ArrayList<>();

        // Assert
        assertEquals(1, students.size());  // Ensure there is one student in the list
        Student savedStudent = students.get(0);
        assertEquals(id, savedStudent.getId());
        assertEquals(name, savedStudent.getName());
        assertEquals(age, savedStudent.getAge());
        assertEquals(email, savedStudent.getEmail());
        assertEquals(course, savedStudent.getCourse());
    }

    /**
     * Test of searchStudent method, of class Student.
     */
    
    
    @Test
    void testSearchStudentFound() {
        // Act
        Student result = new Student(1,"John Doe", 20, "john.doe@example.com", "Computer Science");
        
        // Assert
        assertNotNull(result);  // Ensure a student was found
        assertEquals(1, result.getId());
        assertEquals("John Doe", result.getName());
        assertEquals(20, result.getAge());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals("Computer Science", result.getCourse());
    }

    /**
     * Test of deleteStudent method, of class Student.
     */
    @Test
    public void testDeleteStudent() {
        // Arrange
        Student studentManager = new Student(1,"John Doe", 20, "john.doe@example.com", "Computer Science");
        Student student = new Student(1,"John Doe", 20, "john.doe@example.com", "Computer Science");
        studentManager.students.add(student);

        // Act
        boolean deleted = false;

        // Assert
        assertTrue(deleted);
        assertEquals(0, studentManager.students.size());
    }

    
    /**
     * Test of studentAgeValid method, of class Student.
     */
    @Test
    public void testValidAge() {
        // Act
        boolean isValid = Student.studentAgeValid(20);

        // Assert
        assertTrue(isValid);
    }
    
    @Test
    public void testInvalidAgeTooYoung() {
        // Act
        boolean isValid = Student.studentAgeValid(15);

        // Assert
        assertFalse(isValid);
    }


    /**
     * Test of studentAgeValid method, of class Student.
     */
    @Test
    public void testInvalidAgeNonNumeric() {
        // Act
        boolean isValid = Student.studentAgeValid("abc");

        // Assert
        assertFalse(isValid);
    }
    
}
