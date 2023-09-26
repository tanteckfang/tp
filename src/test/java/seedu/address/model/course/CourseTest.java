package seedu.address.model.course;

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
}
