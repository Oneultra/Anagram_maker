package ua.com.foxminded.anagrams;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnagramMakerTest {

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContainsOneNonLetter() {
        String expected = "d0lrW";
        String actual = AnagramMaker.makeAnagram("W0rld");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContainsOneLetter() {
        String expected = "222E22";
        String actual = AnagramMaker.makeAnagram("222E22");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContainsTheSameLetter() {
        String expected = "HHHHHHH";
        String actual = AnagramMaker.makeAnagram("HHHHHHH");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContainsTheSameNonLetter() {
        String expected = "7777";
        String actual = AnagramMaker.makeAnagram("7777");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContainsDifferentLetter() {
        String expected = "ytrewq";
        String actual = AnagramMaker.makeAnagram("qwerty");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContainsDifferentNonLetter() {
        String expected = "12345";
        String actual = AnagramMaker.makeAnagram("12345");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContainsDifferentLetterCase() {
        String expected = "oLlEh";
        String actual = AnagramMaker.makeAnagram("hElLo");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContains2Or3LetteredWords() {
        String expected = "olleH lufituaeb dlrow";
        String actual = AnagramMaker.makeAnagram("Hello beautiful world");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContains2Or3NonLetteredWords() {
        String expected = "*^&$221 (*77 12223";
        String actual = AnagramMaker.makeAnagram("*^&$221 (*77 12223");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnAnagramWhenSentenceContains2Or3NDifferentWords() {
        String expected = "L3lH0 lu4ft1ueb d0r1w";
        String actual = AnagramMaker.makeAnagram("H3lL0 be4ut1ful w0r1d");

        assertThat(expected, is(equalTo(actual)));
    }

    @Test
    void makeAnagramShouldReturnIllegalArgumentExceptionIfSentenceIsNull() {
        String expected = "Sentence is null";
        String actual = null;

        Throwable thrownException = assertThrows(IllegalArgumentException.class,
                () -> AnagramMaker.makeAnagram(actual));

        assertThat(expected, is(equalTo(thrownException.getMessage())));
    }

    @Test
    void makeAnagramShouldReturnIllegalArgumentExceptionIfSentenceIsEmpty() {
        String expected = "Sentence is empty";
        String actual = "";

        Throwable thrownException = assertThrows(IllegalArgumentException.class,
                () -> AnagramMaker.makeAnagram(actual));

        assertThat(expected, is(equalTo(thrownException.getMessage())));
    }

    @Test
    void makeAnagramShouldReturnIllegalArgumentExceptionIfSentenceContainsTabs() {
        String expected = "Sentence contains only tabulations";
        String actual = "\t";

        Throwable thrownException = assertThrows(IllegalArgumentException.class,
                () -> AnagramMaker.makeAnagram(actual));

        assertThat(expected, is(equalTo(thrownException.getMessage())));
    }
}
