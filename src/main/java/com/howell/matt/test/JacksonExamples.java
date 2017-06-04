package com.howell.matt.test;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.howell.matt.model.Player;

import lombok.extern.slf4j.Slf4j;

/**
 * Jackson examples.
 */
@Slf4j
public class JacksonExamples {

    /**
     * Id.
     */
    private static final String ID = "ID";

    /**
     * Name.
     */
    private static final String NAME = "NAME";

    /**
     * Photo URL.
     */
    private static final String PHOTO_URL = "http://somewhere";

    /**
     * Alias.
     */
    private static final String ALIAS = "ALIAS";

    /**
     * TestPojo.
     */
    private final TestPojo testPojo;

    /**
     * Constructor.
     *
     * @param testPojo test pojo
     */
    public JacksonExamples(final TestPojo testPojo) {
        this.testPojo = testPojo;
    }

    /**
     * Get configured object mapper.
     *
     * @return Object mapper
     */
    public static ObjectMapper getMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    /**
     * Convert object to a string.
     *
     * @param value object
     * @param <T>   object's type
     * @return object as a String
     * @throws JsonProcessingException exception converting object
     */
    public static <T> String getAsString(final T value) throws JsonProcessingException {
        final ObjectMapper mapper = getMapper();
        return mapper.writeValueAsString(value);
    }

    /**
     * Main.
     *
     * @param args args
     */
    public static void main(String[] args) throws JsonProcessingException {
        final Player player = new Player().playerId(ID).displayName(NAME).profilePhotoUrl(PHOTO_URL).alias(ALIAS);
        final TestPojo testPojo = TestPojo.builder().aString("A").aBool(true).anInt(4).player(player).build();

        final JacksonExamples examples = new JacksonExamples(testPojo);

        examples.convertToJsonObject();
        examples.mapPlayerToString(player);
        examples.mapTestPojoToString(testPojo);
        examples.run();
    }

    /**
     * Conversion to JSON object.
     */
    public void convertToJsonObject() {
        final String jsonString = "{\"data\": {\"id\":1, \"name\":\"Matt\"}}";
        final JSONObject rootJO = new JSONObject(jsonString);
        log.info(rootJO.toString());
    }

    /**
     * Convert a player to a string and log it.
     *
     * @param player player
     * @throws JsonProcessingException exception converting object
     */
    public void mapPlayerToString(final Player player) throws JsonProcessingException {
        log.info(getAsString(player));
    }

    /**
     * Convert a test pojo to a string and log it.
     *
     * @param testPojo test pojo
     * @throws JsonProcessingException
     */
    public void mapTestPojoToString(final TestPojo testPojo) throws JsonProcessingException {
        log.info(getAsString(testPojo));
    }

    /**
     * Run.
     */
    public void run() {
        testPojo.setAString("Ridiculous");

        // Find usages fn + opt + f7
        log.info("TestPojo: {}", testPojo);
    }
}
