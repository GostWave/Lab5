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
    public abstract void execute(String argument);

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    public abstract String getDescription();
}
