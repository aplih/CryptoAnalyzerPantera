package com.javarush.toporov;

public class CaesarCipher {
    public final static char[] ALPHABET_UPPER = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
    public final static char[] ALPHABET_LOWER = "абвгдеёдзийклмнопрстуфхцчшщъыьэюя".toCharArray();

    public static String encrypt(String text, int shift) {

        //создание пустой строки для сохранения результата

        StringBuilder result = new StringBuilder();

        //перебор входного текста
        for (int i = 0; i < text.length(); i++) {
            boolean found = false;

            //берем текущий символ из строки
            char currentChar = text.charAt(i);

            //поиск текущей буквы currentChar в массиве ALPHABET
            for (int j = 0; j < ALPHABET_UPPER.length; j++) {

                //сравниваю букву из текста с буквой из алфавита
                if (currentChar == ALPHABET_UPPER[j]) {
                    //j- индекс буквы в алфавите, shift - на сколько нужно сдвинуть, % ALPHABET.length - что бы не выйти за границы
                    int newIndex = (j + shift) % ALPHABET_UPPER.length;

                    if (newIndex < 0) {
                        //добавляем в результат зашифрованную букву
                        newIndex += ALPHABET_UPPER.length;
                    }
                    result.append(ALPHABET_UPPER[newIndex]);
                    found = true;
                    break;
                }
            }
            //если символ не нашёлся в алфавите, проверяем маленькие буквы
            if (!found) {
                for (int j = 0; j < ALPHABET_LOWER.length; j++) {
                    if(currentChar == ALPHABET_LOWER[j]){
                        int newIndex = j + shift;
                        newIndex = newIndex % ALPHABET_LOWER.length;
                        if (newIndex < 0) {
                            newIndex = newIndex + ALPHABET_LOWER.length;
                        }
                        result.append(ALPHABET_LOWER[newIndex]);
                        found = true;
                        break;
                    }

                }

            }
            if (!found){
                result.append(currentChar);
            }
        }


        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

}
