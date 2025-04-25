package commands;

/**
 * ��������� Command, �������������� �������, ������� ����� ���������.
 */
public interface Command {

    /**
     * ��������� �������.
     *
     * @param argument �������� �������
     */
    void execute(String argument);

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    String getDescription();
}
