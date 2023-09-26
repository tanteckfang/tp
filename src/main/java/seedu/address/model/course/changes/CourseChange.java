package seedu.address.model.course.changes;

import static java.util.Objects.requireNonNull;

abstract public class CourseChange {
    public static final String MESSAGE_CONSTRAINTS = "Course change requires either 'add-[course]', 'del-[course]', " +
            "or '[original_course]-[new_course]'";
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
}
