package LoadTestClient;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObjectMapperUtil {
    private static final Logger logger = LoggerFactoryExt.getLogger(ObjectMapperUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public ObjectMapperUtil() {
    }

    public static byte[] serialize(Object object) throws JsonProcessingException {
        try {
            return OBJECT_MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException var2) {
            logger.error("Failed to serialize object;" + ExceptionUtilsEx.getExceptionInformation(var2));
            throw var2;
        }
    }

    public static <T> T deserialize(byte[] data, Class<T> clazz) throws IOException {
        try {
            return OBJECT_MAPPER.readValue(data, clazz);
        } catch (IOException var3) {
            logger.error("Failed to deserialize object;" + ExceptionUtilsEx.getExceptionInformation(var3));
            throw var3;
        }
    }

    public static <T> T deserialize(Object data, Class<T> clazz) throws IOException {
        try {
            String json = toJSON(data, false);
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException var3) {
            logger.error("Failed to deserialize object;" + ExceptionUtilsEx.getExceptionInformation(var3));
            throw var3;
        }
    }

    public static <T> T deserialize(String data, Class<T> clazz) throws IOException {
        try {
            return OBJECT_MAPPER.readValue(data, clazz);
        } catch (IOException var3) {
            logger.error("Failed to deserialize object;" + ExceptionUtilsEx.getExceptionInformation(var3));
            throw var3;
        }
    }

    public static <T> T deserialize(String data, TypeReference<T> type) throws IOException {
        try {
            return OBJECT_MAPPER.readValue(data, type);
        } catch (IOException var3) {
            logger.error("Failed to deserialize object;" + ExceptionUtilsEx.getExceptionInformation(var3));
            throw var3;
        }
    }

    public static String toJSON(Object object) {
        return toJSON(object, true);
    }

    public static String toJSON(Object object, boolean pretty) {
        try {
            return pretty ? OBJECT_MAPPER.writer().withDefaultPrettyPrinter().writeValueAsString(object) : OBJECT_MAPPER.writer().writeValueAsString(object);
        } catch (JsonProcessingException var3) {
            return String.format("Failed to parse to JSON: %s;", ExceptionUtilsEx.getExceptionInformation(var3));
        }
    }

    public static String toJSON(Object object, PropertyNamingStrategy propertyNamingStrategy) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(propertyNamingStrategy);
            return objectMapper.writer().writeValueAsString(object);
        } catch (JsonProcessingException var3) {
            return String.format("Failed to parse to JSON: %s;", ExceptionUtilsEx.getExceptionInformation(var3));
        }
    }


    public static HashMap<String, Object> setDeepObject(String sourceKey, Object valueObj, HashMap<String, Object> topNode, Boolean isArray) {
        HashMap<String, Object> node = null;
        HashMap<String, Object> deepest = topNode;
        ArrayList<Object> deepestArray = null;
        String[] subObjects = sourceKey.split("\\.");
        boolean finished = false;
        if (subObjects.length > 1) {
            int i = subObjects.length - 1;
            int j = 0;
            String subObjectAtJ = subObjects[j];
            if (!topNode.containsKey(subObjects[j])) {
                j = -1;
            } else {
                while(deepest != null && deepest instanceof Map && deepest.containsKey(subObjectAtJ) && (deepest.get(subObjectAtJ) instanceof Map && !isArray || deepest.get(subObjectAtJ) instanceof ArrayList && isArray)) {
                    if (isArray) {
                        deepestArray = (ArrayList)deepest.get(subObjectAtJ);
                    } else {
                        deepest = (HashMap)deepest.get(subObjectAtJ);
                    }

                    ++j;
                    subObjectAtJ = subObjects[j];
                }
            }

            for(; i > 0 && !finished; --i) {
                String subObject = subObjects[i];
                HashMap subObjectHash;
                if (j != i) {
                    subObjectHash = new HashMap();
                    subObjectHash.put(subObject, valueObj);
                    valueObj = subObjectHash;
                } else {
                    if (isArray && deepestArray != null) {
                        subObjectHash = new HashMap();
                        subObjectHash.put(subObject, valueObj);
                        valueObj = subObjectHash;
                        HashMap<String, Object> arrayElement = (HashMap)deepestArray.get(0);
                        arrayElement.putAll(subObjectHash);
                    } else {
                        deepest.put(subObject, valueObj);
                        valueObj = deepest;
                    }

                    finished = true;
                }

                if (node == null) {
                    node = (HashMap)valueObj;
                }
            }

            sourceKey = subObjects[0];
        }

        if (!finished) {
            if (isArray) {
                ArrayList<Object> valueObjArray = new ArrayList();
                valueObjArray.add(valueObj);
                topNode.put(sourceKey, valueObjArray);
            } else {
                topNode.put(sourceKey, valueObj);
            }
        }

        return node;
    }

    public static String getInnerObject(String payloadResult) {
        if (payloadResult == null) {
            return null;
        } else {
            payloadResult = payloadResult.trim();
            if (payloadResult.startsWith("{")) {
                int lastIndexOfEndBrace = payloadResult.lastIndexOf("}");
                payloadResult = payloadResult.substring(1, lastIndexOfEndBrace).trim();
            }

            return payloadResult;
        }
    }

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
    }
}
