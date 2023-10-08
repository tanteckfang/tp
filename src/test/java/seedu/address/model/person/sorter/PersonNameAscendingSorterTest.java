package seedu.address.model.person.sorter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class PersonNameAscendingSorterTest {

    @Test
    public void compareTo_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                new PersonNameAscendingSorter().compare(null, ALICE));
    }

    @Test
    public void compareTo_sameName_returnsTrue() {
        Person firstAlice = new PersonBuilder(ALICE).build();
        Person secondAlice = new PersonBuilder(ALICE).build();

        PersonNameAscendingSorter sorter = new PersonNameAscendingSorter();

        assertTrue(sorter.compare(firstAlice, secondAlice) == 0);
    }

    @Test
    public void compareTo_differentName_returnsTrue() {
        PersonNameAscendingSorter sorter = new PersonNameAscendingSorter();

        assertTrue(sorter.compare(ALICE, BOB) < 0);
        assertTrue(sorter.compare(BOB, ALICE) > 0);
    }

    @Test
    public void equals() {
        PersonNameAscendingSorter personNameAscendingSorter = new PersonNameAscendingSorter();

        // same class -> returns true
        assertTrue(personNameAscendingSorter
                .equals(new PersonNameAscendingSorter()));

        // same object -> returns true
        assertTrue(personNameAscendingSorter.equals(personNameAscendingSorter));

        // null -> returns false
        assertFalse(personNameAscendingSorter.equals(null));

        // different types -> returns false
        assertFalse(personNameAscendingSorter.equals(5.0f));
    }
}
