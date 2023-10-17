package seedu.address.model.course.changes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.model.course.Course;

public class CourseEditTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CourseEdit(null));
    }

    @Test
    public void constructor_invalidDescription_throwsIllegalArgumentException() {
        String invalidDescription = "";
        assertThrows(IllegalArgumentException.class, () -> new CourseEdit(invalidDescription));
    }

    @Test
    public void constructor_invalidCourses_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new CourseEdit("CS210333-MA2001"));
    }

    @Test
    public void isValidCourseEdit() {
        //valid
        assertTrue(CourseEdit.isValidCourseEdit("MA2001-CS2103T"));

        // missing original course
        assertFalse(CourseEdit.isValidCourseEdit("-CS2103T"));

        // missing new course
        assertFalse(CourseEdit.isValidCourseEdit("CS2103T-"));
    }

    @Test
    public void test_getOriginalAndNewCourses() {
        CourseEdit courseEdit = new CourseEdit("MA2001-CS2103T");
        assertEquals(new Course("MA2001"), courseEdit.getOriginalCourse());
        assertEquals(new Course("CS2103T"), courseEdit.getNewCourse());
    }

    @Test
    public void equals() {
        CourseEdit courseEdit = new CourseEdit("MA2001-CS2103T");

        // same values -> returns true
        assertTrue(courseEdit.equals(new CourseEdit("MA2001-CS2103T")));

        // same object -> returns true
        assertTrue(courseEdit.equals(courseEdit));

        // null -> returns false
        assertFalse(courseEdit.equals(null));

        // different types -> returns false
        assertFalse(courseEdit.equals(5.0f));

        // different values -> returns false
        assertFalse(courseEdit.equals(new CourseEdit("CS2103T-MA2001")));
    }
}
