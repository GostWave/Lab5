package collectionObject;

import IO.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import java.time.ZonedDateTime;

/**
 * �����, �������������� ��������� (��������, ��������� ������ ��� ���������).
 * �������� ���������� � ��������, ������� ���, ���� �������� � ����� ��������.
 */
public class Person {

    private String name; // ���� �� ����� ���� null, ������ �� ����� ���� ������
    private ZonedDateTime birthday; // ���� �� ����� ���� null
    private String passportID; // ����� ������ ������ ���� �� ������ 6, ���� �� ����� ���� null

    /**
     * ������������� ��� ���������.
     *
     * @param name name ���������, �� ����� ���� ������.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ������������� ���� �������� ���������.
     *
     * @param birthday ���� �������� ���������, �� ����� ���� null.
     */
    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    /**
     * ������������� ����� �������� ���������.
     *
     * @param passportID ����� ��������, ������ �� ����� ���� ������, ����� ������ ���� �� ������ 6 ��������.
     */
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    /**
     * �������� ��� ���������.
     *
     * @return name ���������.
     */
    @XmlElement
    public String getName() {
        return name;
    }

    /**
     * �������� ���� �������� ���������.
     *
     * @return ���� �������� ���������.
     */
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public ZonedDateTime getBirthday() {
        return birthday;
    }

    /**
     * �������� ����� �������� ���������.
     *
     * @return ����� �������� ���������.
     */
    @XmlElement
    public String getPassportID() {
        return passportID;
    }
}
