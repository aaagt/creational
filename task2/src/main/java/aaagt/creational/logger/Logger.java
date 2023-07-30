package aaagt.creational.logger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Logger {
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger;
    protected int num = 1;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {}

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("[" + TIME_FORMAT.format(timestamp) + " " + num++ + "] " + msg);
    }
}
