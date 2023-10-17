package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class TagUtilTest {

    @Test
    public void canAddOrEditEmergencyTag_noExistingEmergencyTags_returnsTrue() {
        // Arrange
        Person newPerson = new PersonBuilder().withTags("emergency").build();
        List<Person> currentPersons = Arrays.asList(new PersonBuilder().withTags("friend").build());

        // Act
        boolean result = TagUtil.canAddOrEditEmergencyTag(newPerson, currentPersons);

        // Assert
        assertTrue(result);
    }

    @Test
    public void canAddOrEditEmergencyTag_twoExistingEmergencyTags_returnsFalse() {
        // Arrange
        Person newPerson = new PersonBuilder().withTags("emergency").build();
        List<Person> currentPersons = Arrays.asList(
                new PersonBuilder().withTags("emergency").build(),
                new PersonBuilder().withTags("emergency").build()
        );

        // Act
        boolean result = TagUtil.canAddOrEditEmergencyTag(newPerson, currentPersons);

        // Assert
        assertFalse(result);
    }
}
