package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TelehandleTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Telehandle(null));
    }

    @Test
    public void constructor_invalidTelehandle_throwsIllegalArgumentException() {
        String invalidTelehandle = "";
        assertThrows(IllegalArgumentException.class, () -> new Telehandle(invalidTelehandle));
    }

    @Test
    public void isValidTelehandle() {
        // null address
        assertThrows(NullPointerException.class, () -> Telehandle.isValidTelehandle(null));

        // invalid addresses
        assertFalse(Telehandle.isValidTelehandle("")); // empty string
        assertFalse(Telehandle.isValidTelehandle(" ")); // spaces only

        // valid addresses
        assertTrue(Telehandle.isValidTelehandle("nice"));
        assertTrue(Telehandle.isValidTelehandle("-")); // one character
        assertTrue(Telehandle.isValidTelehandle("HiIamACSstudenthihihiilonggggggname")); // long telehandle
    }

    @Test
    public void equals() {
        Telehandle telehandle = new Telehandle("Valid Telehandle");

        // same values -> returns true
        assertTrue(telehandle.equals(new Telehandle("Valid Telehandle")));

        // same object -> returns true
        assertTrue(telehandle.equals(telehandle));

        // null -> returns false
        assertFalse(telehandle.equals(null));

        // different types -> returns false
        assertFalse(telehandle.equals(5.0f));

        // different values -> returns false
        assertFalse(telehandle.equals(new Telehandle("Other Valid Telehandle")));
    }
}
