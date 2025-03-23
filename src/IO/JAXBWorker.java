package IO;

import collectionObject.Movies;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;


/**
 * ����� JAXBWorker ������������� ������ ��� ����������� �������� � XML ������ � �������,
 * ��������� Java Architecture for XML Binding (JAXB).
 * ���� ����� ������������ ��� ������������ � �������������� ��������� ������� �/�� XML.
 */
public class JAXBWorker {

    /**
     * �������� ����� ��� ���������� XML-������.
     * �������� ����� ��������� ����������� �� ���������� ��������� {@code COLLECTION_FILE}.
     */
    private final String fileName = System.getenv("COLLECTION_FILE");

    /**
     * ����������� ������ ��������� ������� � ������ XML.
     *
     * @param collection ��������� �������, ������� ����� ������������� � XML.
     * @return ������, �������������� ��������������� XML.
     * @throws JAXBException ���� ��������� ������ ��� �������� ���������� ��� ������������.
     */
    public String convertObjectToXml(Movies collection) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Movies.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


        OutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(collection, os);

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")) {
            writer.write(os.toString());
            System.out.println("��������� ������� �������� � ����");
        } catch (IOException e) {
            System.out.println("�� ������� �������� ��������� � ����");
        }


        return os.toString();
    }

    /**
     * ����������� ������ XML � ������ ��������� �������.
     *
     * @param text ������ XML, ������� ����� ��������������� � ������.
     * @return ������ ��������� �������, ���������� �� XML.
     */
    public Movies convertXmlToObject(String text) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Movies.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(text);
            return (Movies) un.unmarshal(reader);
        } catch (JAXBException e) {
            System.out.println("�� ������� ��������� ��������� �� �����");
            return null;
        } catch (NumberFormatException e) {
            System.out.println("�������� id ������ � ���������");
            return null;
        }
    }

}