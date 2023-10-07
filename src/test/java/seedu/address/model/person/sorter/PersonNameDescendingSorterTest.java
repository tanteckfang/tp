package seedu.address.model.person.sorter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class PersonNameDescendingSorterTest {

    @Test
    public void compareTo_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                new PersonNameDescendingSorter().compare(null, ALICE));
    }

    @Test
    public void compareTo_sameName_returnsTrue() {
        Person firstAlice = new PersonBuilder(ALICE).build();
        Person secondAlice = new PersonBuilder(ALICE).build();

        PersonNameDescendingSorter sorter = new PersonNameDescendingSorter();

        assertTrue(sorter.compare(firstAlice, secondAlice) == 0);
    }

    @Test
    public void compareTo_differentName_returnsTrue() {
        PersonNameDescendingSorter sorter = new PersonNameDescendingSorter();

        assertTrue(sorter.compare(ALICE, BOB) > 0);
        assertTrue(sorter.compare(BOB, ALICE) < 0);
    }

    @Test
    public void equals() {
        PersonNameDescendingSorter personNameDescendingSorter = new PersonNameDescendingSorter();

        // same class -> returns true
        assertTrue(personNameDescendingSorter
                .equals(new PersonNameDescendingSorter()));

        // same object -> returns true
        assertTrue(personNameDescendingSorter.equals(personNameDescendingSorter));

        // null -> returns false
        assertFalse(personNameDescendingSorter.equals(null));

        // different types -> returns false
        assertFalse(personNameDescendingSorter.equals(5.0f));
    }
}
