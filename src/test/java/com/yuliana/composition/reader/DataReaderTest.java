package com.yuliana.composition.reader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DataReaderTest {
    private DataReader dataReader;
    private String EXPECTED_TEXT =
            "    It has survived - not only (five) centuries, but also the leap into electronic\r\n" +
            "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)\r\n" +
            "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and\r\n" +
            "more recently with desktop publishing software like Aldus PageMaker Faclon9 including\r\n" +
            "versions of Lorem Ipsum!\r\n" +
            "    It is a long a!=b established fact that a reader will be distracted by the readable\r\n" +
            "content of a page when looking at its layout. The point of using Ipsum is that it has a\r\n" +
            "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),\r\n" +
            "content here's, making it look like readable English?\r\n" +
            "    It is a established fact that a reader will be of a page when looking at its layout...\r\n" +
            "    Bye бандерлоги.\r\n";
    private static final String CORRECT_FILE_NAME = "data/test.txt";
    private static final String INCORRECT_FILE_NAME = "incorrect_filename@##";

    @BeforeTest
    private void init(){
        dataReader = new DataReader();
    }

    @Test
    public void readDataCorrectFileNameTest(){
        String actual = dataReader.readData(CORRECT_FILE_NAME);
        assertEquals(actual, EXPECTED_TEXT);
    }

    @Test
    public void readDataIncorrectFileNameTest(){
        String actual = dataReader.readData(INCORRECT_FILE_NAME);
        assertEquals(actual, EXPECTED_TEXT);
    }
}
