package ua.com.foxminded.anagrams;

public class AnagramMaker {

    private static final String DELIMITER = " ";

    public static String makeAnagram(String sentence) {
        validate(sentence);

        final String[] words = sentence.split(DELIMITER);
        final String[] reversedWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = reverseWord(words[i]);
        }

        return concat(reversedWords);
    }

    private static void validate(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Sentence is null");
        }
        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence is empty");
        }
        if (sentence.trim().isEmpty()) {
            throw new IllegalArgumentException("Sentence contains only tabulations");
        }
    }

    private static String reverseWord(String word) {
        char[] characters = word.toCharArray();

        for (int firstIndex = 0, lastIndex = characters.length - 1; firstIndex < lastIndex; ) {
            if (!Character.isAlphabetic(characters[firstIndex])) {
                firstIndex++;
            } else if (!Character.isAlphabetic(characters[lastIndex])) {
                lastIndex--;
            } else {
                swap(characters, firstIndex, lastIndex);
                firstIndex++;
                lastIndex--;
            }
        }

        return String.valueOf(characters);
    }

    private static void swap(char[] targetCharArray, int firstValue, int lastValue) {
        char currentCharacter = targetCharArray[firstValue];
        targetCharArray[firstValue] = targetCharArray[lastValue];
        targetCharArray[lastValue] = currentCharacter;
    }

    private static String concat(String[] reversedWords) {
        return String.join(DELIMITER, reversedWords);
    }
}
