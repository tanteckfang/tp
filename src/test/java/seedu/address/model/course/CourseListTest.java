package seedu.address.model.course;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class CourseListTest {
    @Test
    public void containsValidCourse() {
        CourseList courseList = new CourseList();
        assertTrue(courseList.contains("CS1101S"));
    }

    @Test
    public void containsInvalidCourse() {
        CourseList courseList = new CourseList();
        assertFalse(courseList.contains("CS9999"));
    }

    @Test
    public void containsNullCourse() {
        CourseList courseList = new CourseList();
        assertFalse(courseList.contains(null));
    }

    @Test
    public void containsMultipleCourses() {
        CourseList courseList = new CourseList();
        assertTrue(courseList.contains("CS1101S"));
        assertTrue(courseList.contains("MA1521"));
        assertFalse(courseList.contains("CS9999"));
    }

    @Test
    public void containsCourseWithSpecialCharacters() {
        CourseList courseList = new CourseList();
        assertFalse(courseList.contains("CS-1101S"));
    }

}

