package lec.Lesson_08.Ex006.Format;

import lec.Lesson_08.Ex006.Document.TextDocument;

import java.io.FileWriter;
import java.io.IOException;

public class Txt extends TextFormat {

    @Override
    public void SaveAs(TextDocument document, String path) {
        try (FileWriter writer = new FileWriter(path + ".txt", false)) {
            writer.write("Txt Format\n");
            writer.write(document.getData());
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
