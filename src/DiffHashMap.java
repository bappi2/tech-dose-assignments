import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.regex.Pattern;

public class DiffHashMap {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    final static String filePathSingle = "/Users/mmeftauddin/IdeaProjects/tech-dose-assignments/src/Integ-Event.json";
    final static String filePathMulti = "/Users/mmeftauddin/IdeaProjects/tech-dose-assignments/src/Prod-Event.json";

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception, JsonMappingException {
        File testFile = new File(filePathSingle);
        String fileContent = new String(Files.readAllBytes(Paths.get(testFile.getAbsolutePath())));

        HashMap hashMap = objectMapper.readValue(fileContent, HashMap.class);
        System.out.println(hashMap.get(0).toString());

    }


}
