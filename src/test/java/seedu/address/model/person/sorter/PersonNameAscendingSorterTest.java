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

        // EP: Person 1's name comes before Person 2's name
        assertTrue(sorter.compare(ALICE, BOB) < 0);

        // EP: Person 2's name comes after Person 1's name
        assertTrue(sorter.compare(BOB, ALICE) > 0);
    }

    @Test
    public void compareTo_differentLength_returnsTrue() {
        Person shortNameHoon = new PersonBuilder().withName("Hoon").withPhone("8482424").build();
        Person longNameHoon = new PersonBuilder().withName("Hoon Meier Tan").withPhone("8482424").build();

        PersonNameAscendingSorter sorter = new PersonNameAscendingSorter();

        assertTrue(sorter.compare(shortNameHoon, longNameHoon) < 0);
    }

    @Test
    public void equals() {
        PersonNameAscendingSorter personNameAscendingSorter = new PersonNameAscendingSorter();

        // EP: same class -> returns true
        assertTrue(personNameAscendingSorter
                .equals(new PersonNameAscendingSorter()));

        // EP: same object -> returns true
        assertTrue(personNameAscendingSorter.equals(personNameAscendingSorter));

        // EP: null -> returns false
        assertFalse(personNameAscendingSorter.equals(null));

        // EP: different types -> returns false
        assertFalse(personNameAscendingSorter.equals(5.0f));
    }
}
