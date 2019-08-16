package com.example.test;

import com.example.sax.SAXParserDemo;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

public class Test {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        SAXParserDemo saxParserDemo = new SAXParserDemo();
        saxParserDemo.parser();

    }



}
