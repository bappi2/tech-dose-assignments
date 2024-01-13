# tech-dose-assignments

https://www.geeksforgeeks.org/comparable-vs-comparator-in-java/
https://github.com/Java-Techie-jt
https://github.com/basanta-spring-boot
https://github.com/iamkhs/Head-First-Java
https://docs.google.com/spreadsheets/d/1gy9cmPwNhZvola7kqnfY3DElk7PYrz2ARpaCODTp8Go/edit#gid=0
https://github.com/lokeshgupta1981/Spring-Cloud
https://github.com/Eric-programming/CodeSolution/blob/master/src/Object_Oriented_Programming/Abstraction/Abstraction.java


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

# JSON Processing Libraries: Jackson's `ObjectMapper` vs. `org.json.JSONObject`
https://www.baeldung.com/jackson-object-mapper-tutorial

When working with JSON data in Java, you have the option to choose between different libraries. Two popular choices are Jackson's `ObjectMapper` and the `org.json.JSONObject` class. Both libraries have their own strengths, features, and use cases. Below is a comparison to help you decide which one best suits your needs.

## Library Overview

- **Jackson's `ObjectMapper`:**
    - Part of the Jackson library, a comprehensive JSON-processing library for Java.
    - Offers advanced features for both serialization (Java objects to JSON) and deserialization (JSON to Java objects).
    - Provides a highly customizable and flexible API.

- **`org.json.JSONObject`:**
    - Part of the `org.json` library, a lightweight JSON library for Java.
    - Primarily used for basic JSON manipulation tasks.
    - Has a simpler API compared to Jackson.

## Usage Scenarios

- **Jackson's `ObjectMapper`:**
    - Ideal for projects that require more advanced JSON manipulation, serialization, and deserialization.
    - Suitable for cases involving large or complex JSON structures.
    - Offers better performance for handling demanding use cases.

- **`org.json.JSONObject`:**
    - Best suited for simple JSON tasks, where lightweight functionality is sufficient.
    - Good for projects with minimal JSON requirements.
    - May not perform as well with very large or intricate JSON data.

## Customization and Flexibility

- **Jackson's `ObjectMapper`:**
    - Provides extensive customization options, including custom serializers/deserializers and naming strategies.
    - Allows fine-tuning of serialization and deserialization processes.

- **`org.json.JSONObject`:**
    - Offers fewer customization options compared to Jackson.
    - Simpler and more straightforward API.

## Performance

- **Jackson's `ObjectMapper`:**
    - Known for better performance, especially with larger JSON files and complex structures.
    - Offers options for streaming and incremental parsing, making it memory-efficient.

- **`org.json.JSONObject`:**
    - Suitable for simpler cases, but may not perform as well with very large or complex JSON data.

## Dependencies

- **Jackson's `ObjectMapper`:**
    - Requires inclusion of the Jackson library as a dependency in your project.

- **`org.json.JSONObject`:**
    - Standalone library with no external dependencies.

Choose the library that best aligns with your project's requirements, whether it's the advanced features and customization options of Jackson's `ObjectMapper` or the simplicity and lightweight nature of `org.json.JSONObject`.

Remember to consider factors such as project complexity, performance needs, and customization requirements when making your decision.
