package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Tag {

    public static final String MESSAGE_CONSTRAINTS =
            "Tags names should be alphanumeric, for 'close friends' please type 'cf'";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String tagName;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     */
    public Tag(String tagName) {
        requireNonNull(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        String formattedTagName = formatTagName(tagName);
        this.tagName = formattedTagName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tag)) {
            return false;
        }

        Tag otherTag = (Tag) other;
        return tagName.equals(otherTag.tagName);
    }

    @Override
    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName + ']';
    }

    public boolean isEmergencyTag() {
        return "emergency".equalsIgnoreCase(tagName);
    }

    /**
     * Formats the tag name to ensure consistency in representation.
     */
    private static String formatTagName(String tagName) {
        String formattedTagName = tagName.trim().replaceAll(" +", " ");
        if (formattedTagName.equalsIgnoreCase("cf")) {
            return "Close Friend";
        } else if (formattedTagName.equalsIgnoreCase("emergency")) {
            return "EMERGENCY";
        } else {
            return formattedTagName;
        }
    }
}
