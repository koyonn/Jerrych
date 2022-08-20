package koyonn.jerrych;

/**
 * Интерфейс с методами для форматирования субтитров
 *
 * @author Maksim Tarasenka
 */
interface FormattedTextContract {

    /*
     * Метод для удаления тайм-кодов
     */
    void deleteTimeCodes();

    /*
     * Метод для форматирования текста
     */
    void textFormatting();
}
