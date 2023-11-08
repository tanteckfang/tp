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
    public void compareTo_sameNameDifferentCase_returnsSortedInDictionaryOrder() {
        Person lowercaseHoon = new PersonBuilder().withName("hoon").withPhone("8482424").build();
        Person uppercaseHoon = new PersonBuilder().withName("HOON").withPhone("8482424").build();
        Person mixedCaseHoon = new PersonBuilder().withName("hoOn").withPhone("8482424").build();
        Person secondMixedCaseHoon = new PersonBuilder().withName("HOoN").withPhone("8482424").build();

        PersonNameAscendingSorter sorter = new PersonNameAscendingSorter();

        // Name in the same case should be treated equally
        assertTrue(sorter.compare(uppercaseHoon, uppercaseHoon) == 0);
        assertTrue(sorter.compare(mixedCaseHoon, mixedCaseHoon) == 0);

        // Name in uppercase should come before lowercase
        assertTrue(sorter.compare(uppercaseHoon, lowercaseHoon) < 0);

        // Name that has an uppercase character in between should come before the same name in lower case
        assertTrue(sorter.compare(mixedCaseHoon, lowercaseHoon) < 0);

        // Name that has lowercase characters in between should come after the same name in upper case
        assertTrue(sorter.compare(secondMixedCaseHoon, uppercaseHoon) > 0);

        // Negative test: Names in different cases should not be treated equally.
        assertFalse(sorter.compare(lowercaseHoon, mixedCaseHoon) == 0);
    }

    @Test
    public void compareTo_sameNameWithNumbers_returnsSortedInDictionaryOrder() {
        Person lowercaseHoon = new PersonBuilder().withName("hoon 1").withPhone("8482424").build();
        Person secondLowercaseHoon = new PersonBuilder().withName("hoon 2").withPhone("8482424").build();
        Person lowercaseHoonT = new PersonBuilder().withName("hoon t").withPhone("8482424").build();

        PersonNameAscendingSorter sorter = new PersonNameAscendingSorter();

        // Same names with numbers should be treated equally
        assertTrue(sorter.compare(lowercaseHoon, lowercaseHoon) == 0);

        // Name with the smaller number should come before name with larger number.
        assertTrue(sorter.compare(lowercaseHoon, secondLowercaseHoon) < 0);

        // Numbers should come before characters
        assertTrue(sorter.compare(lowercaseHoon, lowercaseHoonT) < 0);

        // Negative test: Names with different numbers should not be treated equally.
        assertFalse(sorter.compare(lowercaseHoon, secondLowercaseHoon) == 0);
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
