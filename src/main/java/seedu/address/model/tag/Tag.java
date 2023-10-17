package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Tag {

    public static final String MESSAGE_CONSTRAINTS =
            "Only three kinds of tag names are allowed: Friend, Close Friend (or cf), and Emergency'";

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
        String formattedTest = formatTagName(test);
        return formattedTest.equals("Friend") || formattedTest.equals("Close Friend")
                || formattedTest.equals("Emergency");
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
        switch (formattedTagName.toLowerCase()) {
        case "cf":
        case "close friend":
            return "Close Friend";
        case "emergency":
            return "Emergency";
        case "friend":
            return "Friend";
        default:
            return formattedTagName;
        }
    }
}
