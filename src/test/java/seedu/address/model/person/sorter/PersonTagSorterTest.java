package seedu.address.model.person.sorter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.GEORGE;
import static seedu.address.testutil.TypicalPersons.HOON;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;
import seedu.address.testutil.PersonBuilder;

public class PersonTagSorterTest {

    @Test
    public void compareTo_nullPerson_throwsNullPointerException() {
        Person closeFriendAlice = new PersonBuilder(HOON).withTags("Close Friend").build();

        assertThrows(NullPointerException.class, () ->
                new PersonTagSorter().compare(null, closeFriendAlice));
    }

    @Test
    public void compareTo_sameTagsSortedByName_returnsTrue() {
        Person closeFriendGeorge = new PersonBuilder(GEORGE).withTags("Close Friend").build();
        Person closeFriendHoon = new PersonBuilder(HOON).withTags("Close Friend").build();
        Person closeFriendCarl = new PersonBuilder(CARL).withTags("Close Friend").build();
        PersonTagSorter sorter = new PersonTagSorter();

        assertTrue(sorter.compare(closeFriendCarl, closeFriendCarl) == 0);
        assertTrue(sorter.compare(closeFriendCarl, closeFriendGeorge) < 0);
        assertTrue(sorter.compare(closeFriendCarl, closeFriendHoon) < 0);

        assertTrue(sorter.compare(closeFriendGeorge, closeFriendCarl) > 0);
        assertTrue(sorter.compare(closeFriendGeorge, closeFriendGeorge) == 0);
        assertTrue(sorter.compare(closeFriendGeorge, closeFriendHoon) < 0);

        assertTrue(sorter.compare(closeFriendHoon, closeFriendCarl) > 0);
        assertTrue(sorter.compare(closeFriendHoon, closeFriendGeorge) > 0);
        assertTrue(sorter.compare(closeFriendHoon, closeFriendHoon) == 0);
    }

    @Test
    public void compareTo_sameNameSortedByTags_returnsTrue() {
        Person hoon = new PersonBuilder(HOON).build();
        Person friendHoon = new PersonBuilder(HOON).withTags("Friend").build();
        Person closeFriendHoon = new PersonBuilder(HOON).withTags("Close Friend").build();
        Person emergencyHoon = new PersonBuilder(HOON).withTags("Emergency").build();

        PersonTagSorter sorter = new PersonTagSorter();

        assertTrue(sorter.compare(hoon, hoon) == 0);
        assertTrue(sorter.compare(hoon, closeFriendHoon) > 0);
        assertTrue(sorter.compare(hoon, friendHoon) > 0);
        assertTrue(sorter.compare(hoon, emergencyHoon) > 0);

        assertTrue(sorter.compare(closeFriendHoon, closeFriendHoon) == 0);
        assertTrue(sorter.compare(closeFriendHoon, friendHoon) < 0);
        assertTrue(sorter.compare(closeFriendHoon, emergencyHoon) < 0);

        assertTrue(sorter.compare(friendHoon, closeFriendHoon) > 0);
        assertTrue(sorter.compare(friendHoon, friendHoon) == 0);
        assertTrue(sorter.compare(friendHoon, emergencyHoon) < 0);

        assertTrue(sorter.compare(emergencyHoon, closeFriendHoon) > 0);
        assertTrue(sorter.compare(emergencyHoon, friendHoon) > 0);
        assertTrue(sorter.compare(emergencyHoon, emergencyHoon) == 0);
    }

    @Test
    public void compare_differentTagsAndNames_returnsTrue() {
        Person hoon = new PersonBuilder(HOON).build();
        Person friendHoon = new PersonBuilder(HOON).withTags("Friend").build();
        Person closeFriendHoon = new PersonBuilder(HOON).withTags("Close Friend").build();
        Person emergencyHoon = new PersonBuilder(HOON).withTags("Emergency").build();
        Person carl = new PersonBuilder(CARL).withTags("Friend", "Emergency").build();
        Person george = new PersonBuilder(GEORGE).withTags("Close Friend", "Friend", "Emergency").build();

        PersonTagSorter sorter = new PersonTagSorter();

        // Close Friend > Friend > Emergency > No Tags
        // Sort by highest priority tag
        assertTrue(sorter.compare(george, carl) < 0);
        assertTrue(sorter.compare(george, friendHoon) < 0);
        assertTrue(sorter.compare(george, closeFriendHoon) < 0);
        assertTrue(sorter.compare(carl, emergencyHoon) < 0);
        assertTrue(sorter.compare(carl, hoon) < 0);
        assertTrue(sorter.compare(carl, friendHoon) < 0);
    }

    @Test
    public void compareTags_noTags_defaultPriority() {
        Set<Tag> tags1 = new HashSet<>();
        Set<Tag> tags2 = new HashSet<>();
        PersonTagSorter sorter = new PersonTagSorter();

        int tagComparison = sorter.compareTags(tags1, tags2);
        assertEquals(0, tagComparison);
    }

    @Test
    public void compareTags_singleTag_singleTagPriority() {
        Set<Tag> tags1 = new HashSet<>();
        tags1.add(new Tag("Friend"));

        Set<Tag> tags2 = new HashSet<>();
        tags2.add(new Tag("Close Friend"));

        PersonTagSorter sorter = new PersonTagSorter();

        int tagComparison = sorter.compareTags(tags1, tags2);
        assertEquals(1, tagComparison);
    }

    @Test
    public void compareTags_mixedNumberOfSameTags_highestPriority() {
        Set<Tag> tags1 = new HashSet<>();
        tags1.add(new Tag("Emergency"));
        tags1.add(new Tag("Friend"));

        Set<Tag> tags2 = new HashSet<>();
        tags2.add(new Tag("Close Friend"));
        tags2.add(new Tag("Emergency"));

        PersonTagSorter sorter = new PersonTagSorter();

        int tagComparison = sorter.compareTags(tags1, tags2);
        assertEquals(1, tagComparison); // tags2 has a higher-priority tag
    }

    @Test
    public void compareTags_mixedNumberOfDifferentTags_highestPriority() {
        Set<Tag> tags1 = new HashSet<>();

        Set<Tag> tags2 = new HashSet<>();
        tags2.add(new Tag("Friend"));
        tags2.add(new Tag("Emergency"));

        PersonTagSorter sorter = new PersonTagSorter();

        int tagComparison = sorter.compareTags(tags1, tags2);
        assertEquals(1, tagComparison);
    }

    @Test
    public void compareTags_sameTags_samePriority() {
        Set<Tag> tags1 = new HashSet<>();
        tags1.add(new Tag("Emergency"));
        tags1.add(new Tag("Friend"));

        Set<Tag> tags2 = new HashSet<>();
        tags2.add(new Tag("Friend"));
        tags2.add(new Tag("Emergency"));

        PersonTagSorter sorter = new PersonTagSorter();

        int tagComparison = sorter.compareTags(tags1, tags2);
        assertEquals(0, tagComparison);
    }

    @Test
    public void getMaxTagPriority_noTags_defaultPriority() {
        Set<Tag> tags = new HashSet<>();
        PersonTagSorter sorter = new PersonTagSorter();
        int maxPriority = sorter.getMaxTagPriority(tags);
        assertEquals(Integer.MAX_VALUE, maxPriority);
    }

    @Test
    public void getMaxTagPriority_singleTag_singleTagPriority() {
        Set<Tag> tags = new HashSet<>();
        PersonTagSorter sorter = new PersonTagSorter();

        tags.add(new Tag("Friend"));
        int maxPriority = sorter.getMaxTagPriority(tags);
        assertEquals(2, maxPriority);
    }

    @Test
    public void getMaxTagPriority_multipleTags_highestPriority() {
        Set<Tag> tags = new HashSet<>();
        PersonTagSorter sorter = new PersonTagSorter();

        tags.add(new Tag("Emergency"));
        tags.add(new Tag("Close Friend"));
        tags.add(new Tag("Friend"));
        int maxPriority = sorter.getMaxTagPriority(tags);
        assertEquals(1, maxPriority);
    }
}
