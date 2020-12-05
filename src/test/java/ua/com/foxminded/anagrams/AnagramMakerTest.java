package ua.com.foxminded.anagrams;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AnagramMakerTest {

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContainsOneNonLetter() {
        String expected = "d0lrW";
        String actual = AnagramMaker.makeAnagram("W0rld");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContainsOneLetter() {
        String expected = "222E22";
        String actual = AnagramMaker.makeAnagram("222E22");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContainsTheSameLetter() {
        String expected = "HHHHHHH";
        String actual = AnagramMaker.makeAnagram("HHHHHHH");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContainsTheSameNonLetter() {
        String expected = "7777";
        String actual = AnagramMaker.makeAnagram("7777");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContainsDifferentLetter() {
        String expected = "ytrewq";
        String actual = AnagramMaker.makeAnagram("qwerty");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContainsDifferentNonLetter() {
        String expected = "12345";
        String actual = AnagramMaker.makeAnagram("12345");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContainsDifferentLetterCase() {
        String expected = "oLlEh";
        String actual = AnagramMaker.makeAnagram("hElLo");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContains2Or3LetteredWords() {
        String expected = "olleH lufituaeb dlrow";
        String actual = AnagramMaker.makeAnagram("Hello beautiful world");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContains2Or3NonLetteredWords() {
        String expected = "*^&$221 (*77 12223";
        String actual = AnagramMaker.makeAnagram("*^&$221 (*77 12223");

        assertEquals(expected, actual);
    }

    @Test
    public void makeAnagramShouldReturnAnagramWhenSentenceContains2Or3NDifferentWords() {
        String expected = "L3lH0 lu4ft1ueb d0r1w";
        String actual = AnagramMaker.makeAnagram("H3lL0 be4ut1ful w0r1d");

        assertEquals(expected, actual);
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void makeAnagramShouldReturnIllegalArgumentExceptionIfSentenceIsNull() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sentence is null");

        AnagramMaker.makeAnagram(null);
    }

    @Test
    public void makeAnagramShouldReturnIllegalArgumentExceptionIfSentenceIsEmpty() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sentence is empty");

        AnagramMaker.makeAnagram("");
    }

    @Test
    public void makeAnagramShouldReturnIllegalArgumentExceptionIfSentenceContainsTabs() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Sentence contains only tabulations");

        AnagramMaker.makeAnagram("\t");
    }
}
