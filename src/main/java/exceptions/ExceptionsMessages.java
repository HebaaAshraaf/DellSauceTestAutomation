package exceptions;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ExceptionsMessages {
    static void InvalidSelectorMsg(InvalidSelectorException e) {
        System.out.println("Error occurred: Please Check your elements locators syntax.. " +
                "This error happens when the locator is invalid.. " + e.getMessage());
    }

    static void NoSuchElementMsg(NoSuchElementException e) {
        System.out.println("Error occurred: Please Check your elements locators or increase " +
                "the waiting time.. " + e.getMessage());
    }

    static void ElementNotVisibleMsg(ElementNotVisibleException e) {
        System.out.println("Error occurred: your elements is not visible.. " + e.getMessage());
    }

    static void NoSuchSessionMsg(NoSuchSessionException e) {
        System.out.println("Error occurred: your browser may be crashed.. " + e.getMessage());
    }

    static void IOMsg(IOException e) {
        System.out.println("Error occurred: Please check your File path.. " + e.getMessage());
    }

    static void FileNotFoundMsg(FileNotFoundException e) {
        System.out.println("Error occurred: we can not find your file.. " + e.getMessage());
    }

    static void JSONParseMsg(org.json.simple.parser.ParseException e) {
        System.out.println("Error occurred: we can not parse your json file.. " + e.getMessage());
    }

    static void NullPointerMsg(NullPointerException e) {
        System.out.println("Error occurred: we can not parse your json file.. " + e.getMessage());
    }
}
