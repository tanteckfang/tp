package seedu.address.model.person.sorter;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PersonCourseSizeAscendingSorterTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                new PersonCourseSizeAscendingSorter(null));
    }

    // other tests will be written later.
}

