package seedu.address.model.person.sorter;

import java.util.Comparator;

import seedu.address.model.person.Person;

/**
 * An abstract class representing a sorter for persons in the address book.
 * Subclasses of this class define specific sorting criteria.
 */
public abstract class PersonSorter implements Comparator<Person> {

    /**
     * Creates a person sorter object based on the criterion provided.
     * @param criterion the description provided.
     * @return a PersonSorter object corresponding to the criterion.
     */
    public static PersonSorter createPersonSorter(String criterion) {
        switch (criterion) {
        case "name":
        case "name-ascending":
            return new PersonNameAscendingSorter();
        case "name-descending":
            return new PersonNameDescendingSorter();
        case "course":
        case "course size-descending":
            return new PersonCourseSizeDescendingSorter();
        case "course size-ascending":
            return new PersonCourseSizeAscendingSorter();
        default:
            return null;
        }
    }
}
