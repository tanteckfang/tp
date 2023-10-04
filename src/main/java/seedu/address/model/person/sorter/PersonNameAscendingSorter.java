package seedu.address.model.person.sorter;

import seedu.address.model.person.Person;

/**
 * A sorter for persons in the address book based on name in ascending lexicographic order.
 * Subclass of {@link PersonSorter}.
 */
public class PersonNameAscendingSorter extends PersonSorter {

    @Override
    public int compare(Person person1, Person person2) {
        // Convert to uppercase so as to compare ASCII values
        String person1UpperCaseName = person1.getName().fullName.toUpperCase();
        String person2UpperCaseName = person2.getName().fullName.toUpperCase();
        return person1UpperCaseName.compareTo(person2UpperCaseName);
    }
}
