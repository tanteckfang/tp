package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format theme of the address book.
 */
public class ThemeCommand extends Command {

    public static final String COMMAND_WORD = "theme";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes the theme of NUSCoursemates "
            + "to dark or light mode.\n"
            + "Parameters: THEME \n"
            + "Example: " + COMMAND_WORD + " dark";

    public static final String MESSAGE_SUCCESS = "Changed theme.";

    public final boolean isLight;

    public ThemeCommand(boolean isLight) {
        this.isLight = isLight;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS, false, false, false,
                isLight, !isLight);

    }

}
