package fr.epita.assistants.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.codehaus.plexus.util.cli.CommandLineTimeOutException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Json {

    public static HashMap<String, String> hashMap = new HashMap<String, String>();
    public static void addToJson(String str1, String str2, String str3)
    {
        hashMap.put(str1, str2);
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode();

        for (Map.Entry<String, String> entry : hashMap.entrySet())
        {
            node.put(entry.getKey(), entry.getValue());
        }

        try {
            objectMapper.writeValue(new File(str3), node);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}