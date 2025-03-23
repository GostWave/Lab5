package collectionObject;

import IO.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


import java.time.ZonedDateTime;

/**
 *  ласс, представл€ющий персонажа (например, оператора фильма или режиссера).
 * —одержит информацию о человеке, включа€ им€, дату рождени€ и номер паспорта.
 */
public class Person {

    private String name; // ѕоле не может быть null, строка не может быть пустой
    private ZonedDateTime birthday; // ѕоле не может быть null
    private String passportID; // ƒлина строки должна быть не меньше 6, поле не может быть null

    /**
     * ”станавливает им€ персонажа.
     *
     * @param name name персонажа, не может быть пустым.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ”станавливает дату рождени€ персонажа.
     *
     * @param birthday ƒата рождени€ персонажа, не может быть null.
     */
    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    /**
     * ”станавливает номер паспорта персонажа.
     *
     * @param passportID Ќомер паспорта, строка не может быть пустой, длина должна быть не меньше 6 символов.
     */
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    /**
     * ѕолучает им€ персонажа.
     *
     * @return name персонажа.
     */
    @XmlElement
    public String getName() {
        return name;
    }

    /**
     * ѕолучает дату рождени€ персонажа.
     *
     * @return ƒата рождени€ персонажа.
     */
    @XmlElement
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public ZonedDateTime getBirthday() {
        return birthday;
    }

    /**
     * ѕолучает номер паспорта персонажа.
     *
     * @return Ќомер паспорта персонажа.
     */
    @XmlElement
    public String getPassportID() {
        return passportID;
    }
}
