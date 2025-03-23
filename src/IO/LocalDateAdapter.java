package IO;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;

/**
 * ������� ��� �������������� {@link Temporal} �������� (LocalDate � ZonedDateTime)
 * � ��������� ������ XML � �������.
 */
public class LocalDateAdapter extends XmlAdapter<String, Temporal> {
    private static final DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateTimeFormatter ZONED_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    /**
     * ����������� ��������� ������������� ���� � ������ {@link Temporal}.
     *
     * @param v ��������� ������������� ����
     * @return ������ {@link ZonedDateTime}, ���� ������ �������� 'T', ����� {@link LocalDate}
     */
    @Override
    public Temporal unmarshal(String v) {
        if (v == null) {
            return null;
        }

        if (v.contains("T")) {
            return ZonedDateTime.parse(v, ZONED_DATE_TIME_FORMATTER);
        } else {
            return LocalDate.parse(v, LOCAL_DATE_FORMATTER);
        }
    }

    /**
     * ����������� ������ {@link Temporal} � ��������� �������������.
     *
     * @param v ������ {@link Temporal} ��� ��������������
     * @return ��������� ������������� ����
     */
    @Override
    public String marshal(Temporal v) {
        if (v == null) {
            return null;
        }

        if (v instanceof ZonedDateTime) {
            return ((ZonedDateTime) v).format(ZONED_DATE_TIME_FORMATTER);
        } else {
            return ((LocalDate) v).format(LOCAL_DATE_FORMATTER);
        }
    }
}
