package seedu.address.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import seedu.address.model.course.Course;

/**
 * JsonCourseParser is a utility class for parsing a JSON file containing course data
 * and extracting module codes into a list of strings.
 */
public class JsonCourseParser {

    public static final Path COURSE_PATH = Paths.get("data", "JSONModuleList.json");

    /**
     * Parses a JSON file and extracts module codes into a set of strings.
     *
     * @param jsonFilePath The path to the JSON file to be parsed.
     * @return A set of module codes extracted from the JSON file.
     * @throws IOException If an I/O error occurs or if the JSON file does not exist or has invalid format.
     */
    public static Set<String> parseJsonFile(Path jsonFilePath) throws IOException {

        if (!Files.exists(jsonFilePath)) {
            throw new IOException("JSON file does not exist: " + jsonFilePath.toString());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = jsonFilePath.toFile();
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        if (!rootNode.isArray()) {
            throw new IOException("Invalid JSON format. Expected an array of courses.");
        }

        Set<String> courseList = new HashSet<>();

        for (JsonNode courseNode : rootNode) {
            String moduleCode = courseNode.get("moduleCode").asText();
            courseList.add(moduleCode);
        }

        return courseList;
    }

    /**
     * Initializes course data by parsing a JSON file and initializing a Course class.
     * This method is intended to be used at the beginning of the application.
     */
    public static void initialise() {
        try {
            Set<String> courseList = parseJsonFile(COURSE_PATH);
            Course.initialiseCourseList(courseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

