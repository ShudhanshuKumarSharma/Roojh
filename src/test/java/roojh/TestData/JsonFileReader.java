package roojh.TestData;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {

	public static List<HashMap<String, String>> readJsonData() throws IOException {

		File fileObject = new File(System.getProperty("user.dir") + "\\src\\test\\java\\roojh\\TestData\\JSONFile.json");

		String jsonToStringFile = FileUtils.readFileToString(fileObject, StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> hashmapObject = mapper.readValue(jsonToStringFile,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return hashmapObject;

	}

}
