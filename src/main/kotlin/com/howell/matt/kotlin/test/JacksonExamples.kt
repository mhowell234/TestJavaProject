package com.howell.matt.kotlin.test

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.howell.matt.model.Player
import org.json.JSONObject

/**
 * Jackson examples.
 */
class JacksonExamples(
        val testPojo: TestPojo) {

    val log = loggerFor(::JacksonExamples.javaClass)

    /**
     * Get configured object mapper.
     *
     * @return Object mapper
     */
    val mapper: ObjectMapper
        get() {
            val mapper = ObjectMapper()
            mapper.registerModule(Jdk8Module())
            mapper.registerModule(JavaTimeModule())
            return mapper
        }

    companion object {
        /** Id. */
        private val ID = "ID"

        /** Name. */
        private val NAME = "NAME"

        /** Photo URL. */
        private val PHOTO_URL = "http://somewhere"

        /**
         * Alias.
         */
        private val ALIAS = "ALIAS"

        /**
         * Main.

         * @param args args
         * @throws JsonProcessingException exception parsing object
         */
        @Throws(JsonProcessingException::class)
        @JvmStatic fun main(args: Array<String>) {
            val player = Player().playerId(ID).displayName(NAME).profilePhotoUrl(PHOTO_URL).alias(ALIAS)
            val testPojo = TestPojo(aString = "A", aBool = true, anInt = 4, player = player)

            val examples = JacksonExamples(testPojo)

            examples.convertToJsonObject()
            examples.mapPlayerToString(player)
            examples.mapTestPojoToString(testPojo)
            examples.run()
        }
    }

    /**
     * Convert object to a string.
     *
     * @param value object
     * @param <T>   object's type
     * @return object as a String
     * @throws JsonProcessingException exception converting object
     */
    @Throws(JsonProcessingException::class)
    fun <T> getAsString(value: T): String {
        return mapper.writeValueAsString(value)
    }

    /**
     * Conversion to JSON object.
     */
    fun convertToJsonObject() {
        val jsonString = "{\"data\": {\"id\":1, \"name\":\"Matt\"}}"
        val rootJO = JSONObject(jsonString)
        log.info(rootJO.toString())
    }

    /**
     * Convert a player to a string and log it.

     * @param player player
     * @throws JsonProcessingException exception converting object
     */
    @Throws(JsonProcessingException::class)
    fun mapPlayerToString(player: Player) {
        log.info(getAsString(player))
    }

    /**
     * Convert a test pojo to a string and log it.
     *
     * @param testPojo test pojo
     * @throws JsonProcessingException exception converting object
     */
    @Throws(JsonProcessingException::class)
    fun mapTestPojoToString(testPojo: TestPojo) {
        log.info(getAsString(testPojo))
    }

    /**
     * Run.
     */
    fun run() {
        testPojo.aString = "Ridiculous"

        // Find usages fn + opt + f7
        log.info("TestPojo: {}", testPojo)
    }
}
