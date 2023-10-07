package seedu.address.model.person.sorter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class PersonCourseSizeAscendingSorterTest {

    @Test
    public void compareTo_nullPerson_throwsNullPointerException() {
        Person oneCourseAlice = new PersonBuilder(ALICE).withCourses("MA2001").build();

        assertThrows(NullPointerException.class, () ->
                new PersonCourseSizeAscendingSorter().compare(null, oneCourseAlice));
    }

    @Test
    public void compareTo_differentCourseSizeSameName_returnsTrue() {

        Person oneCourseAlice = new PersonBuilder(ALICE).withCourses("MA2001").build();
        Person twoCourseAlice = new PersonBuilder(ALICE).withCourses("MA2001", "EC2101").build();

        PersonCourseSizeAscendingSorter sorter = new PersonCourseSizeAscendingSorter();

        // oneCourseAlice has fewer courses than twoCourseAlice, so it should come before twoCourseAlice
        assertTrue(sorter.compare(oneCourseAlice, twoCourseAlice) < 0);

        // twoCourseAlice has more courses than oneCourseAlice, so it should come after oneCourseAlice
        assertTrue(sorter.compare(twoCourseAlice, oneCourseAlice) > 0);
    }

    @Test
    public void compareTo_differentCourseSizeAndName_returnsTrue() {

        Person oneCourseAlice = new PersonBuilder(ALICE).withCourses("MA2001").build();
        Person twoCourseBob = new PersonBuilder(BOB).withCourses("MA2001", "EC2101").build();

        PersonCourseSizeAscendingSorter sorter = new PersonCourseSizeAscendingSorter();

        // oneCourseAlice has fewer courses than twoCourseBob, so it should come before twoCourseBob
        assertTrue(sorter.compare(oneCourseAlice, twoCourseBob) < 0);

        // twoCourseBob has more courses than oneCourseAlice, so it should come after oneCourseAlice
        assertTrue(sorter.compare(twoCourseBob, oneCourseAlice) > 0);
    }

    @Test
    public void compareTo_courseSizeIsZero_returnsTrue() {

        Person zeroCourseAlice = new PersonBuilder(ALICE).withCourses().build();
        Person twoCourseBob = new PersonBuilder(BOB).withCourses("MA2001", "EC2101").build();

        PersonCourseSizeAscendingSorter sorter = new PersonCourseSizeAscendingSorter();

        // zeroCourseAlice has fewer courses than twoCourseBob, so it should come before twoCourseBob
        assertTrue(sorter.compare(zeroCourseAlice, twoCourseBob) < 0);

        // twoCourseBob has more courses than zeroCourseAlice, so it should come after zeroCourseAlice
        assertTrue(sorter.compare(twoCourseBob, zeroCourseAlice) > 0);
    }

    @Test
    public void compareTo_sameCourseSizeAndName_returnsTrue() {

        Person zeroCourseAlice = new PersonBuilder(ALICE).withCourses().build();
        Person anotherZeroCourseAlice = new PersonBuilder(ALICE).withCourses().build();

        PersonCourseSizeAscendingSorter sorter = new PersonCourseSizeAscendingSorter();

        assertTrue(sorter.compare(zeroCourseAlice, anotherZeroCourseAlice) == 0);
    }

    @Test
    public void compareTo_sameCourseSizeDifferentName_returnsTrue() {

        Person oneCourseAlice = new PersonBuilder(ALICE).withCourses("MA2001").build();
        Person oneCourseBob = new PersonBuilder(BOB).withCourses("EC2101").build();

        PersonCourseSizeAscendingSorter sorter = new PersonCourseSizeAscendingSorter();

        // oneCourseAlice has the same number of courses as oneCourseBob,
        // so it should come before oneCourseBob (sort by lexicographic order)
        assertTrue(sorter.compare(oneCourseAlice, oneCourseBob) < 0);

        // oneCourseBob has the same number of courses as oneCourseAlice,
        // so it should come after oneCourseAlice (sort by lexicographic order)
        assertTrue(sorter.compare(oneCourseBob, oneCourseAlice) > 0);
    }

    @Test
    public void equals() {
        PersonCourseSizeAscendingSorter personCourseSizeAscendingSorter = new PersonCourseSizeAscendingSorter();

        // same class -> returns true
        assertTrue(personCourseSizeAscendingSorter
                .equals(new PersonCourseSizeAscendingSorter()));

        // same object -> returns true
        assertTrue(personCourseSizeAscendingSorter.equals(personCourseSizeAscendingSorter));

        // null -> returns false
        assertFalse(personCourseSizeAscendingSorter.equals(null));

        // different types -> returns false
        assertFalse(personCourseSizeAscendingSorter.equals(5.0f));
    }
}
