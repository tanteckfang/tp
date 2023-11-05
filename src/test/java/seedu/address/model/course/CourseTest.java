package seedu.address.model.course;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class CourseTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Course(null));
    }

    @Test
    public void constructor_invalidCourseName_throwsIllegalArgumentException() {
        String invalidCourseName = "";
        assertThrows(IllegalArgumentException.class, () -> new Course(invalidCourseName));
    }

    @Test
    public void isValidCourseName() {
        // null course name
        assertThrows(NullPointerException.class, () -> Course.isValidCourseName(null));
    }

    @Test
    public void isValidCourseName_validCourseNameLowerCase() {
        assertTrue(Course.isValidCourseName("cs101")); // Valid course name in lowercase
    }

    @Test
    public void isValidCourseName_emptyCourseName_returnsFalse() {
        assertFalse(Course.isValidCourseName("")); // Empty course name should be invalid
    }

    @Test
    public void isValidCourseName_invalidCourseName_returnsFalse() {
        assertFalse(Course.isValidCourseName("CS-101")); // Invalid course name with special characters
    }

    @Test
    public void isValidCourseName_courseNameWithDifferentLengths() {
        assertTrue(Course.isValidCourseName("CS1"));
        assertTrue(Course.isValidCourseName("CS12345"));
    }

    @Test
    public void isValidCourseName_nullCourseName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> Course.isValidCourseName(null));
    }

    @Test
    public void isValidCourseName_singleCharacterCourseName() {
        assertTrue(Course.isValidCourseName("A")); // Single character course name (valid)
    }

}
