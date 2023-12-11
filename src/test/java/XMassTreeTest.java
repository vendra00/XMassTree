import com.adasoft.XMassTree;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class XMassTreeTest {
    @Test
    public void testXMassTreeHeightOf5() {
        // Capture the original System.out and System.in
        PrintStream originalOut = System.out;
        InputStream originalIn = System.in;

        try {
            // Set up a new output stream to capture the program's output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            // Prepare the input stream with user input
            String input = "5"; // Include the newline character
            ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
            System.setIn(inContent);

            // Call the main method of XMassTree to run the program
            XMassTree.main(new String[]{});

            // Define the expected output
            String normalizedExpectedOutput = getExpectedXMassTree();
            String normalizedActualOutput = outContent.toString().replace("\r\n", "\n");

            // Assert that the actual output matches the expected output
            assertEquals(normalizedExpectedOutput, normalizedActualOutput);
        } finally {
            // Restore the original System.out and System.in
            System.setOut(originalOut);
            System.setIn(originalIn);
        }
    }

    private static String getExpectedXMassTree() {
        String expectedOutput =
                """
                        Insert Tree Height:\s
                        
                             *
                            ***
                           *****
                          *******
                         *********
                        """;

        // Normalize line endings to avoid platform-specific issues
        return expectedOutput.replace("\r\n", "\n");
    }
}



