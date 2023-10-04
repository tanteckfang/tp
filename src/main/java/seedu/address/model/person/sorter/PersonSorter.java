package seedu.address.model.person.sorter;

import java.util.Comparator;

import seedu.address.model.person.Person;

/**
 * An abstract class representing a sorter for persons in the address book.
 * Subclasses of this class define specific sorting criteria.
 */
public abstract class PersonSorter implements Comparator<Person> {
    protected String criterion;

    /**
     * Creates a person sorter object based on the criterion provided.
     * @param criterion the sorting requirement provided.
     * @return a PersonSorter object which satisfies the criterion.
     */
    public static PersonSorter createPersonSorter(String criterion) {
        switch (criterion) {
        case "name":
        case "name-ascending":
            return new PersonNameAscendingSorter("name-ascending");
        case "name-descending":
            return new PersonNameDescendingSorter("name-descending");
        case "course":
        case "course size-descending":
            return new PersonCourseSizeDescendingSorter("course size-descending");
        case "course size-ascending":
            return new PersonCourseSizeAscendingSorter("course size-ascending");
        default:
            return null;
        }
    }

    public String getSortingCriterion() {
        return criterion;
    }
}
