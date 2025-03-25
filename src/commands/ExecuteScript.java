package commands;

import app.App;
import app.ConsoleCaller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
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
        HashSet<String> callScripts= new HashSet<>();
        try {
            Scanner scanner = new Scanner(new File(argument));

            while (scanner.hasNext()) {
                String text = scanner.nextLine().trim();
                System.out.println(text);
                if (text.length()>4 && text.substring(text.length() - 4).equals(".txt")){
                    callScripts.add(text.split(" ")[1]);
                }
                if (text.substring(text.length() - 4).equals(".txt") && callScripts.contains(text.split(" ")[1])){
                    System.out.println("�������� ��������");
                    break;
                } else {
                    consoleCaller.call(text);
                }



            }
        } catch (FileNotFoundException e) {
            System.out.println("������� �������� ��� ����� ��� ����������� ���� �����������");
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
