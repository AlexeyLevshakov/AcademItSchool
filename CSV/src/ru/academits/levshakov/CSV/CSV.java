package ru.academits.levshakov.CSV;

import javax.swing.text.html.HTML;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSV {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder HTMLTableString = new StringBuilder();
        HTMLTableString.append("<table>");

        try (Scanner scanner = new Scanner(new FileInputStream("CSV\\Input.txt"), "windows-1251")) {
            while (scanner.hasNextLine()) {
                HTMLTableString.append("<tr>");
                String line = scanner.nextLine();
                String[] cells = line.split(",");
                for (String cell : cells) {
                    if (cell.contains("\"")) {
                         int first = cell.indexOf("\"");
                    }

                    HTMLTableString.append("<td>");
                    HTMLTableString.append(cell);
                    HTMLTableString.append("</td>");
                }
                HTMLTableString.append("</tr>");
            }
        }

        HTMLTableString.append("</table>");
        String text = HTMLTableString.toString();

        System.out.println(text);
    }
}
