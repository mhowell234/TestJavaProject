package com.howell.matt.test;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
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
        final var mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);

        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new JodaModule());

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
        final var mapper = getMapper();
        return mapper.writeValueAsString(value);
    }

    /**
     * Main.
     *
     * @param args args
     * @throws JsonProcessingException exception parsing object
     */
    public static void main(String[] args) throws JsonProcessingException {
        final var player = new Player().playerId(ID).displayName(NAME).profilePhotoUrl(PHOTO_URL).alias(ALIAS);
        final var testPojo = TestPojo.builder().aString("A").aBool(true).anInt(4).player(player).build();

        final var examples = new JacksonExamples(testPojo);

        examples.convertToJsonObject();
        examples.mapPlayerToString(player);
        examples.mapTestPojoToString(testPojo);
        examples.run();
    }

    /**
     * Conversion to JSON object.
     */
    public void convertToJsonObject() {
        final var jsonString = "{\"data\": {\"id\":1, \"name\":\"Matt\"}}";
        final var rootJO = new JSONObject(jsonString);
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
     * @throws JsonProcessingException exception converting object
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
