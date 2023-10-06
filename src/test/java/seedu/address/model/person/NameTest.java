package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));

        String otherInvalidName = "!!!@!EEW";
        assertThrows(IllegalArgumentException.class, () -> new Name(otherInvalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> Name.isValidName(null));

        // invalid name
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces only
        assertFalse(Name.isValidName("^")); // only non-alphanumeric characters
        assertFalse(Name.isValidName("peter*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(Name.isValidName("peter jack")); // alphabets only
        assertTrue(Name.isValidName("12345")); // numbers only
        assertTrue(Name.isValidName("peter the 2nd")); // alphanumeric characters
        assertTrue(Name.isValidName("Capital Tan")); // with capital letters
        assertTrue(Name.isValidName("David Roger Jackson Ray Jr 2nd")); // long names
    }

    @Test
    public void testCompareTo() {
        Name upperCaseName = new Name("AARON TAN");
        Name lowerCaseName = new Name("aaron tan");
        Name mixedCaseName = new Name("aAron Tan");
        Name otherUpperCaseName = new Name("COLIN TAN");
        Name otherLowerCaseName = new Name("colin tan");
        Name otherMixedCaseName = new Name("coLiN tan");

        // Same names (in different cases) should return 0.
        assertEquals(0, upperCaseName.compareTo(lowerCaseName));
        assertEquals(0, upperCaseName.compareTo(mixedCaseName));
        assertEquals(0, upperCaseName.compareTo(upperCaseName));

        assertEquals(0, lowerCaseName.compareTo(lowerCaseName));
        assertEquals(0, lowerCaseName.compareTo(mixedCaseName));
        assertEquals(0, lowerCaseName.compareTo(upperCaseName));

        assertEquals(0, mixedCaseName.compareTo(lowerCaseName));
        assertEquals(0, mixedCaseName.compareTo(mixedCaseName));
        assertEquals(0, mixedCaseName.compareTo(upperCaseName));

        // Test comparisons between different names (compared lexicographically)
        // but names are in same case
        assertTrue(upperCaseName.compareTo(otherUpperCaseName) < 0);
        assertTrue(otherUpperCaseName.compareTo(upperCaseName) > 0);

        assertTrue(lowerCaseName.compareTo(otherLowerCaseName) < 0);
        assertTrue(otherLowerCaseName.compareTo(lowerCaseName) > 0);

        assertTrue(mixedCaseName.compareTo(otherMixedCaseName) < 0);
        assertTrue(otherMixedCaseName.compareTo(mixedCaseName) > 0);

        // Test comparisons between different names in different cases.
        assertTrue(upperCaseName.compareTo(otherLowerCaseName) < 0);
        assertTrue(upperCaseName.compareTo(otherMixedCaseName) < 0);

        assertTrue(lowerCaseName.compareTo(otherUpperCaseName) < 0);
        assertTrue(lowerCaseName.compareTo(otherMixedCaseName) < 0);

        assertTrue(mixedCaseName.compareTo(otherLowerCaseName) < 0);
        assertTrue(mixedCaseName.compareTo(otherUpperCaseName) < 0);

        assertTrue(otherUpperCaseName.compareTo(lowerCaseName) > 0);
        assertTrue(otherUpperCaseName.compareTo(mixedCaseName) > 0);

        assertTrue(otherLowerCaseName.compareTo(upperCaseName) > 0);
        assertTrue(otherLowerCaseName.compareTo(mixedCaseName) > 0);

        assertTrue(otherMixedCaseName.compareTo(lowerCaseName) > 0);
        assertTrue(otherMixedCaseName.compareTo(upperCaseName) > 0);
    }

    @Test
    public void equals() {
        Name name = new Name("Valid Name");

        // same values -> returns true
        assertTrue(name.equals(new Name("Valid Name")));

        // same object -> returns true
        assertTrue(name.equals(name));

        // null -> returns false
        assertFalse(name.equals(null));

        // different types -> returns false
        assertFalse(name.equals(5.0f));

        // different values -> returns false
        assertFalse(name.equals(new Name("Other Valid Name")));
    }
}
