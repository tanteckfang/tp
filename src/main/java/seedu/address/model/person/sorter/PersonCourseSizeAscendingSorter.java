package seedu.address.model.person.sorter;

import static java.util.Objects.requireNonNull;

import seedu.address.model.person.Person;

/**
 * A sorter for persons in the address book based on the number of courses taken.
 * Persons are sorted from the least to the most number of courses taken.
 * Subclass of {@link PersonSorter}.
 */
public class PersonCourseSizeAscendingSorter extends PersonSorter {

    /**
     * Constructs a {@code PersonCourseSizeAscendingSorter}.
     *
     * @param courseSizeAscending Description of the sorting criterion.
     */
    public PersonCourseSizeAscendingSorter(String courseSizeAscending) {
        requireNonNull(courseSizeAscending);
        criterion = courseSizeAscending;
    }

    @Override
    public int compare(Person person1, Person person2) {

        int courseSizeComparison = Integer.compare(person1.getCourses().size(), person2.getCourses().size());

        if (courseSizeComparison != 0) {
            return courseSizeComparison;
        } else {
            // Sort by name when course sizes are similar.
            // Convert to uppercase to compare ASCII values
            String person1UpperCaseName = person1.getName().fullName.toUpperCase();
            String person2UpperCaseName = person2.getName().fullName.toUpperCase();

            return person1UpperCaseName.compareTo(person2UpperCaseName);
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PersonCourseSizeAscendingSorter)) {
            return false;
        }

        PersonCourseSizeAscendingSorter otherCourseSizeAscendingSorter = (PersonCourseSizeAscendingSorter) other;
        return this.getSortingCriterion().equals(otherCourseSizeAscendingSorter.getSortingCriterion());
    }

    @Override
    public int hashCode() {
        return criterion.hashCode();
    }
}
