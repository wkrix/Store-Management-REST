package hu.klayton.wade.sm.util;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@Component
public class DateFormatter implements Formatter<Date> {

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(text);
    }

    @Override
    public String print(Date date, Locale locale) {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
}
