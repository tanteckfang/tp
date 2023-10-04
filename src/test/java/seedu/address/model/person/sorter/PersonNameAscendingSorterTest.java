package seedu.address.model.person.sorter;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PersonNameAscendingSorterTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                new PersonNameAscendingSorter(null));
    }

    // other tests will be written later.

}
