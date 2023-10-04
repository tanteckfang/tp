package seedu.address.model.person.sorter;

import seedu.address.model.person.Person;

/**
 * A sorter for persons in the address book based on name in descending lexicographic order.
 * Subclass of {@link PersonSorter}.
 */
public class PersonNameDescendingSorter extends PersonSorter {

    @Override
    public int compare(Person person1, Person person2) {
        // Convert to uppercase so as to compare ASCII values
        String person1UpperCaseName = person1.getName().fullName.toUpperCase();
        String person2UpperCaseName = person2.getName().fullName.toUpperCase();
        return person2UpperCaseName.compareTo(person1UpperCaseName);
    }
}
