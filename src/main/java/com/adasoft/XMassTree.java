package com.adasoft;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * This program prints a Christmas tree of a specified height.
 */
public class XMassTree {
    public static void main(String[] args) {
        // Pass System.in as the InputStream to getHeight
        int height = (int) getHeight(System.in);

        // Create a StringBuilder to store the tree
        StringBuilder tree = new StringBuilder();

        // Build the tree
        xMassTreeBuilder(height, tree);

        // Print the entire tree at once
        System.out.print(tree);

    }

    /**
     * Builds the tree.
     * @param height Height of the tree
     * @param tree StringBuilder to store the tree
     */
    private static void xMassTreeBuilder(int height, StringBuilder tree) {

        for (int i = 0; i < height; i++) { // Loop through each row of the tree
            int spacesToAppend = height - i; // Number of spaces to append in each row
            int asterisksToAppend = 2 * i + 1; // Number of asterisks to append in each row

            // Strings to append
            String asterisks = "*"; // Asterisks to append
            String spaces = " "; // Spaces to append
            String newline = "\n"; // Newline character

            // Append spaces
            tree.append(printingTreeNodes(spacesToAppend, spaces));

            // Append asterisks with random colors
            applyColorToXMassTree(tree, asterisksToAppend, asterisks);

            // Append a newline character
            tree.append(newline);
        }
    }

    private static void applyColorToXMassTree(StringBuilder tree, int asterisksToAppend,String asterisks) {

        // Define ANSI color codes
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_ORANGE = "\u001B[38;5;208m";
        final String ANSI_RESET = "\u001B[0m";

        // Define an array of colors
        String[] colors = {ANSI_GREEN, ANSI_RED, ANSI_YELLOW, ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_ORANGE};

        Random random = new Random();

        for (int j = 0; j < asterisksToAppend; j++) {
            // Select a random color for each asterisk
            String color = colors[random.nextInt(colors.length)];
            tree.append(color).append(asterisks).append(ANSI_RESET);
        }
    }

    /**
     * Obtains the height of the tree from user input with validation.
     * @param in InputStream to read from
     * @return Height of the tree (positive double) or -1.0 if input is invalid
     */
    public static double getHeight(InputStream in) {
        try (Scanner scanner = new Scanner(in)) {
            // Prompt the user for input
            System.out.print("Insert Tree Height: ");

            // Validate input
            double height = validateDoubleInput(scanner);

            System.out.println("\n"); // Print a newline character to separate the tree from the prompt

            // Return the height
            return height;
        }
    }

    /**
     * Validates the user input.
     * @param scanner Scanner to read from
     * @return Validated input
     */
    private static double validateDoubleInput(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                if (input > 0) {
                    return input; // Valid input
                }else {
                    System.out.print("Invalid input. Height cannot be a negative number or zero. Try again: "); // Prompt the user for input
                    scanner.nextLine(); // Consume the invalid input
                }
            } else {
                System.out.print("Invalid input. Height cannot be a character. Try again: "); // Prompt the user for input
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }

    /**
     * Creates a string of a specified number of spaces or asterisks.
     * @param count Number of characters to generate
     * @param character The character to repeat
     * @return A string of repeated characters
     */
    public static String printingTreeNodes(int count, String character) {
        return character.repeat(count); // Repeat the character count times
    }
}
