package com.javarush.toporov;

public class CaesarCipher {
    public final static char[] ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();

    public static String encrypt(String text, int shift) {

        //создание пустой строки для сохранения результата
        StringBuilder result = new StringBuilder();

        //перебор входного текста
        for (int i = 0; i < text.length(); i++) {
            boolean found = false;

            //берем текущий символ из строки
            char currentChar = text.charAt(i);

            //поиск текущей буквы currentChar в массиве ALPHABET
            for (int j = 0; j < ALPHABET.length; j++) {

                //сравниваю букву из текста с буквой из алфавита
                if (currentChar == ALPHABET[j]) ;
                //j- индекс буквы в алфавите, shift - на сколько нужно сдвинуть,  % ALPHABET.length - что бы не выйти за границы
                int newIndex = (j + shift) % ALPHABET.length;

                if (newIndex < 0)
                    //добавляем в результат зашифрованную букву
                result.append(ALPHABET[newIndex]);
                //если true значит буква обработана
                found = true;
                break;
            }
            //если символ не нашёлся в алфавите, оставляем без изменений
            if (!found) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return null;
    }

}
