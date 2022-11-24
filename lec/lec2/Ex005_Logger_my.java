package lec.lec2;

// // import java.util.logging.ConsoleHandler;
// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// // import java.util.logging.SimpleFormatter;
// import java.util.logging.XMLFormatter;
import java.io.IOException;
import java.util.logging.*;


public class Ex005_Logger_my {
    //пока не добавила throws IOException - выдавал ошибку в строке
    //        FileHandler fh = new FileHandler("log.xml");

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Ex005_Logger_my.class.getName());
        // ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("log.xml");
//указываем ch в качестве аргумента логеру, чтоб было понятно, куда сообщения отправлять
        // logger.addHandler(ch);
        logger.addHandler(fh);

        //описываем формат, в котором будет запись/вывод сообщений
        // SimpleFormatter sFormat = new SimpleFormatter();
        XMLFormatter xml = new XMLFormatter();
       // ch.setFormatter(sFormat);
        //ch.setFormatter(xml);
        fh.setFormatter(xml);

        //указываем уровень и сообщение
        // logger.setLevel(Level.INFO);
        logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info("Тестовое логирование 2"); //чтоб каждый раз не указывать уровень - info
    }
}
