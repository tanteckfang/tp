package seedu.address.model.course;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.util.CourseUtil;

public class CourseListTest {
    @Test
    public void containsValidCourse() {
        assertTrue(CourseUtil.contains("CS1101S"));
    }

    @Test
    public void containsInvalidCourse() {
        assertFalse(CourseUtil.contains("CS9999"));
    }

    @Test
    public void containsNullCourse() {
        assertFalse(CourseUtil.contains(null));
    }

    @Test
    public void containsMultipleCourses() {
        assertTrue(CourseUtil.contains("CS1101S"));
        assertTrue(CourseUtil.contains("MA1521"));
        assertFalse(CourseUtil.contains("CS9999"));
    }

    @Test
    public void containsCourseWithSpecialCharacters() {
        assertFalse(CourseUtil.contains("CS-1101S"));
    }

}

