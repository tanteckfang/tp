package seedu.address.model.course.changes;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.model.course.Course;

/**
 * Represents a course addition.
 */
public class CourseAddition extends CourseChange {
    public static final String MESSAGE_CONSTRAINTS = "Course addition needs 'add' followed by an alphanumeric string.";
    public static final String COURSE_ADDITION_PREFIX = "add-";
    private static final Pattern COURSE_ADDITION_PATTERN = Pattern.compile("^add-(?<course>[A-Za-z0-9]+)$");
    private static Matcher matcher;
    private final Course courseToAdd;

    /**
     * Constructs a {@code CourseAddition}.
     *
     * @param courseAdditionDescription Description for course addition.
     */
    public CourseAddition(String courseAdditionDescription) {
        requireNonNull(courseAdditionDescription);
        checkArgument(isValidCourseAddition(courseAdditionDescription), MESSAGE_CONSTRAINTS);
        courseChangeDescription = courseAdditionDescription;
        String courseToAddName = matcher.group("course");
        checkArgument(Course.isValidCourseName(courseToAddName), Course.MESSAGE_INVALID_COURSE);
        courseToAdd = new Course(courseToAddName);
    }

    /**
     * Returns true if a given string follows the specified pattern.
     */
    public static boolean isValidCourseAddition(String test) {
        matcher = COURSE_ADDITION_PATTERN.matcher(test);
        return matcher.matches();
    }

    /**
     * Returns true if a given description contains valid courses, given that it already fulfills the "add-" template.
     * @param description the description i.e. "add-CS2103T"
     * @return whether the course to add is valid
     */
    public static boolean checkIfValidCourse(String description) {
        matcher = COURSE_ADDITION_PATTERN.matcher(description);
        if (matcher.find()) {
            return Course.isExistingCourseName(matcher.group("course"));
        }
        return false;
    }

    public static String getParsedCourseName(String description) {
        matcher = COURSE_ADDITION_PATTERN.matcher(description);
        return matcher.find() ? matcher.group("course") : null;
    }

    public Course getCourseToAdd() {
        return courseToAdd;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CourseAddition)) {
            return false;
        }

        CourseAddition otherCourseAddition = (CourseAddition) other;
        return courseToAdd.equals(otherCourseAddition.courseToAdd);
    }

    @Override
    public int hashCode() {
        return courseToAdd.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return "[Course to add: " + courseToAdd + "]";
    }
}
