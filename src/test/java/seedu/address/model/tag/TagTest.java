package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidTagName));
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
    }

    @Test
    public void checkIsEmergencyTag() {
        // not emergency tag
        Tag notEmergency = new Tag("friend");
        assertFalse(notEmergency.isEmergencyTag());

        // emergency tag
        Tag emergency = new Tag("emergency");
        assertTrue(emergency.isEmergencyTag());
    }

    @Test
    public void createEmergencyTag_allLowerCase_convertsToUpperCase() {
        // Arrange
        String inputTagName = "emergency";
        String expectedTagName = "EMERGENCY";

        // Act
        Tag tag = new Tag(inputTagName);

        // Assert
        assertEquals(expectedTagName, tag.tagName);
    }

    @Test
    public void createCloseFriendTag_allowAnyCase() {
        String expectedTagName = "Close Friend";

        // All upper case
        String upperCaseTagName = "CF";
        Tag firstTag = new Tag(upperCaseTagName);
        assertEquals(expectedTagName, firstTag.tagName);

        //case insensitive
        String inputTagName = "cF";
        Tag secondTag = new Tag(inputTagName);
        assertEquals(expectedTagName, secondTag.tagName);
    }
}
