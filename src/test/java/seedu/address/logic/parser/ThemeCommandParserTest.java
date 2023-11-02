package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ThemeCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class ThemeCommandParserTest {
    @Test
    public void parse_validDarkTheme_success() {
        ThemeCommandParser parser = new ThemeCommandParser();
        try {
            ThemeCommand command = parser.parse("dark");
            assertEquals(command.isLight, false);
        } catch (ParseException e) {
            assertTrue(false);
        }
    }

    @Test
    public void parse_validLightTheme_success() {
        ThemeCommandParser parser = new ThemeCommandParser();
        try {
            ThemeCommand command = parser.parse("LIGHT");
            assertEquals(command.isLight, true);
        } catch (ParseException e) {
            assertTrue(false);
        }
    }

    @Test
    public void parse_emptyInput_throwsParseException() {
        ThemeCommandParser parser = new ThemeCommandParser();
        assertThrows(ParseException.class, () -> parser.parse(""));
    }

    @Test
    public void parse_invalidInput_throwsParseException() {
        ThemeCommandParser parser = new ThemeCommandParser();
        assertThrows(ParseException.class, () -> parser.parse("INVALID_THEME"));
    }
}
