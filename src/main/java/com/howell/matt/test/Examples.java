package com.howell.matt.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.stepfunctions.AWSStepFunctions;
import com.amazonaws.services.stepfunctions.AWSStepFunctionsClientBuilder;
import com.amazonaws.services.stepfunctions.model.ListStateMachinesRequest;
import com.amazonaws.services.stepfunctions.model.ListStateMachinesResult;
import com.amazonaws.services.stepfunctions.model.StateMachineListItem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.howell.matt.model.Player;

/**
 * Live templates
 */
public class Examples {
    private static final String STRING = "A String";
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String PHOTO_URL = "http://somewhere";
    private static final String ALIAS = "ALIAS";

    private final Pojo pojo;

    // psf
    public static final int a = 1;

    // psfs
    // shift + cmd + U = toggle case
    public static final String c = "dd";

    // prsf
    private static final boolean b = false;

    // "private FileOutputStream " ctrl + space to suggest name
    private FileOutputStream fileOutputStream;

    // psvm
    public static void main(String[] args) throws Exception {

        final Player player = new Player().playerId(ID).displayName(NAME).profilePhotoUrl(PHOTO_URL).alias(ALIAS);
        final Pojo pojo = Pojo.builder().aString("A").aBool(true).anInt(4).player(player).build();

        Examples examples = new Examples(pojo);
        examples.testJsonObject();
        examples.testJacksonMapperPlayer(player);
        examples.testJacksonMapperPojo(pojo);
        examples.showStateMachines();
        examples.showS3Buckets();
        examples.run();
    }

    public Examples(final Pojo pojo) {
        this.pojo = pojo;
    }

    public void run() {
        char[] c = new char[] {'a', 'b', 'c'};

        // itar
        for (int i = 0; i < c.length; i++) {
            char c1 = c[i];

        }

        pojo.setAString("Ridiculous");

        // anInt.for + tab
        for (char c1 : c) {

        }

        // Find:
        // cmd + o // open class
        // opt + cmd + o // find symbol
        // shift + cmd + o // open file
        // cmd + l // go to line/col

        // cmd + aBool = find def
        // opt + cmd + aBool = find implementation

        // cmd + [ and cmd + ] to go back/forward in history

        // shift + cmd + T = Create test class
        // ctrl + cmd + Up => go to related classes (Class -> Test, etc.)

        // highlight usages = fn + shift + command + F7...cmd + G to cycle
        // cmd + N to generate
        // ctrl + O to override
        // cmd + D to duplicate block/current line

        // fn + f2 to jump to errors
        // cmd + E = recent files
        // shift + cmd + delete to go to last edit location

        int[] i = new int[] {1, 2, 3};

        for (int j = 0; j < i.length; j++) {
            int i1 = i[j];
        }

        // opt + enter to list imports
        // shift + ctrl + space after new to auto complete instant
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        map.put("aString", 1);

        // map.put(). cursor inside Parens...cmd + P to show params

        // command J

        // cmd + option + t to surround
        // cmd + option + t ...6 for try/catch
        //sout
        System.out.println("String:");
        System.out.println(STRING);

        // ctrl + up for selection

        // cmd + option + / to block comment


        // "String s = (" then press ctrl space
        String s = (String) "adf";

        // Find usages fn + opt + f7
        System.out.println(pojo);
        map.put("aBool", 2);
    }

    public void testJsonObject() {
        String jsonString = "{\"data\": {\"id\":1, \"name\":\"Matt\"}}";
        JSONObject rootJO = new JSONObject(jsonString);
        System.out.println(rootJO.toString());
    }

    public void testJacksonMapperPlayer(final Player player) throws JsonMappingException, JsonProcessingException {
        System.out.println(getAsString(player));
    }

    public void testJacksonMapperPojo(final Pojo pojo) throws JsonMappingException, JsonProcessingException {
        System.out.println(getAsString(pojo));
    }

    public void showStateMachines() {
        final AWSStepFunctions awsStepFunctions = awsStepFunctions();
        awsStepFunctions.listStateMachines(new ListStateMachinesRequest()).getStateMachines().forEach(System.out::println);
    }

    public void showS3Buckets() {
        final AmazonS3 amazonS3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
        amazonS3.listBuckets().stream().map(Bucket::getName).forEach(System.out::println);
    }

    public static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    public static AWSStepFunctions awsStepFunctions() {
        return AWSStepFunctionsClientBuilder.standard().withRegion(Regions.US_WEST_2).build();
    }

    public static <T> String getAsString(final T value) throws JsonProcessingException {
        final ObjectMapper mapper = getMapper();
        return mapper.writeValueAsString(value);
    }
}