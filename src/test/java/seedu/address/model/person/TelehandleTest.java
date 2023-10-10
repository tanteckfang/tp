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
        String invalidTelehandle = "amyyyy"; // no @ infront
        assertThrows(IllegalArgumentException.class, () -> new Telehandle(invalidTelehandle));
    }

    @Test
    public void isValidTelehandle() {
        // invalid telehandle
        assertFalse(Telehandle.isValidTelehandle("marylovejinheng")); // no @
        assertFalse(Telehandle.isValidTelehandle("asdasd@asdasd")); // @ in the middle
        assertFalse(Telehandle.isValidTelehandle("@marylove jinheng")); // white spaces
        assertFalse(Telehandle.isValidTelehandle("@*!@~")); // no other special characters apart from underscores

        // valid telehandles
        assertTrue(Telehandle.isValidTelehandle("@nice")); //default
        assertTrue(Telehandle.isValidTelehandle("@nice_")); // underscore as a special character are allowed.
        assertTrue(Telehandle.isValidTelehandle("@HiIamACSstudenthihihiilonggggggname")); // long telehandle
    }

    @Test
    public void equals() {
        Telehandle telehandle = new Telehandle("@ValidTelehandle");

        // same values -> returns true
        assertTrue(telehandle.equals(new Telehandle("@ValidTelehandle")));

        // same object -> returns true
        assertTrue(telehandle.equals(telehandle));

        // null -> returns false
        assertFalse(telehandle.equals(null));

        // different types -> returns false
        assertFalse(telehandle.equals(5.0f));

        // different values -> returns false
        assertFalse(telehandle.equals(new Telehandle("@OtherValidTelehandle")));
    }
}
