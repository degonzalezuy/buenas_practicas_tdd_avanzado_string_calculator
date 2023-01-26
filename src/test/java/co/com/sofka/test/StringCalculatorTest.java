package co.com.sofka.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    public StringCalculator stringCalculator = new StringCalculator();
    // Una cadena vacía devuelve cero
    @Test
    public void emptyStringTest()throws Exception{
        assertEquals(0, stringCalculator.add(""));
    }
    // Un solo número devuelve el valor
    @Test
    public void singleNumberReturnItsValueTest() throws Exception{
        assertEquals(2, stringCalculator.add("2"));
        assertEquals(1, stringCalculator.add("1"));
    }
    //Dos números, delimitados por comas, devuelven la suma
    @Test
    public void twoNumbersCommaDelimitedReturnsTheSumTest() throws Exception{
        assertEquals(2, stringCalculator.add("0,2"));
        assertEquals(2, stringCalculator.add("1,1"));
        assertEquals(3, stringCalculator.add("1,2"));
    }

    // Dos números, delimitados por saltos de línea, devuelve la suma
    @Test
    public void sameThatBeforeButNewLineDelimitedTest()throws Exception{
        assertEquals(2, stringCalculator.add("0\n2"));
        assertEquals(2, stringCalculator.add("1\n1"));
        assertEquals(3, stringCalculator.add("1\n2"));
    }
    // Tres números, delimitados de cualquier manera, devuelven la suma
    @Test
    public void sameThatBeforeButAllDelimitersWorksTest() throws Exception {
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(7, stringCalculator.add("1,2\n4"));
    }

    // Los números negativos arrojan una excepción
    /*@Test(expected = Exception.class)
    public void negativeNumbersThrowsAnExceptionTest() throws Exception {
        stringCalculator.add("-1,-1");
    }*/

    // Los números superiores a 1000 se ignoran
    @Test
    public void greaterThan1000AreIgnoredTest() throws Exception {
        assertEquals(1002, stringCalculator.add("2,1000"));
        assertEquals(2, stringCalculator.add("2,1001"));
    }
    //Se puede definir un solo delimitador de caracteres en la primera línea (p. Ej., // # para un "#" como delimitador)
    @Test
    public void singleCharDelimiterTest() throws Exception {
        assertEquals(1002, stringCalculator.add("#2#1000"));
    }

    /*@Test
    public void moreThanOneCharDelimiterTest() throws Exception {
        assertEquals(1002, stringCalculator.add("##2##1000"));
    }*/
}