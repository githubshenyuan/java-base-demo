package com.example.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

public class SAXParserDemo {

    public void parser() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        // 设置内容处理器
        xmlReader.setContentHandler( new MyHandler());
        // 设置
        // 解析xml
        xmlReader.parse(new InputSource(new StringReader(getXml())));

    }


    public static class MyHandler extends DefaultHandler {

        //
        @Override
        public void setDocumentLocator(Locator locator) {
            System.out.println(locator.getPublicId());
            System.out.println(locator.getSystemId());
            super.setDocumentLocator(locator);
        }
        //解析文档开始时，执行
        @Override
        public void startDocument() throws SAXException {
            System.out.println("==================== 开始解析文档 ====================");
            super.startDocument();
        }
        //解析文档结束时，执行
        @Override
        public void endDocument() throws SAXException {
            System.out.println("==================== 结束解析文档 ====================");
            super.endDocument();
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            super.startPrefixMapping(prefix, uri);
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            super.endPrefixMapping(prefix);
        }
        //解析文档时，遇到节点开头时，执行
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("==================== 开始解析节点 ====================");
            System.out.println("uri: " + uri);
            System.out.println("localName: " + localName);
            System.out.println("qName: " + qName);
            System.out.println("attributes: " + attributes);
            super.startElement(uri, localName, qName, attributes);
        }
        //解析文档时，遇到节点结尾时，执行
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("==================== 结束解析节点 ====================");
            super.endElement(uri, localName, qName);
        }
        // //解析文档时，遇到节点里面的值时，执行
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println(String.format("==================== characters %s  %s====================",start,length));
            String value=new String(ch,start,length);
            System.out.println("节点值: " + value);
            //super.characters(ch, start, length);
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
            super.ignorableWhitespace(ch, start, length);
        }

        @Override
        public void processingInstruction(String target, String data) throws SAXException {
            super.processingInstruction(target, data);
        }

        @Override
        public void skippedEntity(String name) throws SAXException {
            super.skippedEntity(name);
        }

    }

    public static class MyDTDHandler extends DefaultHandler {
        @Override
        public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName) throws SAXException {
            super.unparsedEntityDecl(name, publicId, systemId, notationName);
        }
    }

    public String getXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<persons>\n" +
                "    <person>\n" +
                "        <name>至尊宝</name>\n" +
                "        <age>99</age>\n" +
                "    </person>\n" +
                "    <person>\n" +
                "        <name>紫霞仙子</name>\n" +
                "        <age>89</age>\n" +
                "    </person>\n" +
                " \n" +
                "    <person>\n" +
                "        <name>白晶晶</name>\n" +
                "        <age>79</age>\n" +
                "    </person>\n" +
                "</persons>";
    }

}
