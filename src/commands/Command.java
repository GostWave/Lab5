package commands;

/**
 * »нтерфейс Command, представл€ющий команду, которую можно выполнить.
 */
public interface Command {

    /**
     * ¬ыполн€ет команду.
     *
     * @param argument аргумент команды
     */
    void execute(String argument);

    /**
     * ¬озвращает описание команды.
     *
     * @return строка с описанием команды
     */
    String getDescription();
}
