package xml_parsing;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, DateTime> {
    private static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy.MM.dd");

    @Override
    public DateTime unmarshal(String date) {
        return formatter.parseDateTime(date);
    }

    @Override
    public String marshal(DateTime dateTime) {
        return formatter.print(dateTime);
    }
}
