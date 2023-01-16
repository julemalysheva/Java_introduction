package Sem5_OOP.MVP;

import java.io.File;

public interface View {
    Double getValue(String title);
    char getOperation(String title);
    void viewResult(String result, String title);
    void viewLog(File file);
}
