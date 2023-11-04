package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's telehandle in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTelehandle(String)}
 */
public class Telehandle {

    public static final String MESSAGE_CONSTRAINTS = "Telehandle can take any values, "
            + "but it has to start with @ and no spaces in between.";

    /*
     * The first character of the telehandle must be a @,
     */
    public static final String VALIDATION_REGEX = "@[a-zA-Z0-9_]*[a-zA-Z]+[a-zA-Z0-9_]*";
    public static final Telehandle EMPTY_TELEHANDLE = new Telehandle("");

    public final String value;

    /**
     * Constructs an {@code telehandle}.
     *
     * @param telehandle A valid  telehandle.
     */
    public Telehandle(String telehandle) {
        requireNonNull(telehandle);
        checkArgument(isValidTelehandle(telehandle), MESSAGE_CONSTRAINTS);
        value = telehandle;
    }

    /**
     * Returns true if a given string is a valid telehandle.
     */
    public static boolean isValidTelehandle(String test) {
        return test.isEmpty() || test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Telehandle)) {
            return false;
        }

        Telehandle otherTelehandle = (Telehandle) other;
        return value.equals(otherTelehandle.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
