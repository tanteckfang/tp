package seedu.address.model.person.sorter;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PersonCourseSizeDescendingSorterTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                new PersonCourseSizeDescendingSorter(null));
    }

    // other tests will be written later.
}
