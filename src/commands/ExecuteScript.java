package commands;

import app.App;
import app.ConsoleCaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ����� ������� ExecuteScript, ��������������� ��� ���������� ������ �� ���������� �����.
 */
public class ExecuteScript implements Command {
    final ConsoleCaller consoleCaller = App.getApp().getConsoleCaller();

    /**
     * ��������� �������, �������� ������� �� ����� � �������� �� ���������������.
     *
     * @param argument ��� �����, ����������� ������� ��� ����������
     */
    @Override
    public void execute(String argument) {
        try {
            Scanner scanner = new Scanner(new File(argument));
            while (scanner.hasNext()) {
                String text = scanner.nextLine();
                System.out.println(text);
                consoleCaller.call(text);
            }
        } catch (FileNotFoundException e) {
            System.out.println("������� �������� ��� ����� ��� ����������� ���� �����������");
        } catch (StackOverflowError e) {
            System.out.println("������: �� ������ ��������� ��������");
        }
    }

    /**
     * ���������� �������� �������.
     *
     * @return ������ � ��������� �������
     */
    @Override
    public String getDescription() {
        return "������� � ��������� ������ �� ���������� �����. � ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������";
    }
}
