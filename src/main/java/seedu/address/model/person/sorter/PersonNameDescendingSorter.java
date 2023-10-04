package seedu.address.model.person.sorter;

import static java.util.Objects.requireNonNull;

import seedu.address.model.person.Person;

/**
 * A sorter for persons in the address book based on name in descending lexicographic order.
 * Subclass of {@link PersonSorter}.
 */
public class PersonNameDescendingSorter extends PersonSorter {

    /**
     * Constructs a {@code PersonNameDescendingSorter}.
     *
     * @param nameDescending Description of the sorting criterion.
     */
    public PersonNameDescendingSorter(String nameDescending) {
        requireNonNull(nameDescending);
        criterion = nameDescending;
    }

    @Override
    public int compare(Person person1, Person person2) {
        // Convert to uppercase so as to compare ASCII values
        String person1UpperCaseName = person1.getName().fullName.toUpperCase();
        String person2UpperCaseName = person2.getName().fullName.toUpperCase();
        return person2UpperCaseName.compareTo(person1UpperCaseName);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PersonNameDescendingSorter)) {
            return false;
        }

        PersonNameDescendingSorter otherPersonNameDescendingSorter = (PersonNameDescendingSorter) other;
        return this.getSortingCriterion().equals(otherPersonNameDescendingSorter.getSortingCriterion());
    }

    @Override
    public int hashCode() {
        return criterion.hashCode();
    }
}
