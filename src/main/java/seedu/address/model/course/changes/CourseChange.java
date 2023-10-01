package seedu.address.model.course.changes;

import static java.util.Objects.requireNonNull;

/**
 * Represents a course change.
 */
public abstract class CourseChange {
    public static final String MESSAGE_CONSTRAINTS = "Course change requires either 'add-[course]', 'del-[course]', "
            + "or '[original_course]-[new_course]'";

    protected String courseChangeDescription;

    /**
     * Creates a course change object based on the description provided.
     * @param courseChangeDescription the description provided.
     * @return the course change object.
     */
    public static CourseChange createCourseChange(String courseChangeDescription) {
        requireNonNull(courseChangeDescription);
        // order of if else is important, due to regex pattern.
        if (CourseAddition.isValidCourseAddition(courseChangeDescription)) {
            return new CourseAddition(courseChangeDescription);
        } else if (CourseDeletion.isValidCourseDeletion(courseChangeDescription)) {
            return new CourseDeletion(courseChangeDescription);
        } else if (CourseEdit.isValidCourseEdit(courseChangeDescription)) {
            return new CourseEdit(courseChangeDescription);
        } else {
            return null;
        }
    }

    public String getCourseChangeDescription() {
        return courseChangeDescription;
    }
}
