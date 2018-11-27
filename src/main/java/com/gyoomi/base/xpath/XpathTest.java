/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.base.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/11/27 9:48
 */
public class XpathTest {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // 开启验证
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("error : " + exception.getMessage());
            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error : " + exception.getMessage());
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("error : " + exception.getMessage());
            }
        });
        // 將一个文档添加到document对象中去
        Document document = documentBuilder.parse("src/main/java/com/gyoomi/base/xpath/inventory.xml");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        // 编译XPath表达式
        XPathExpression expr = xPath.compile("//book[author='Neal Stephenson']/title/text()");
        // 通过XPath 表达式得到结采，第一个参数指定了XPath 表达式进行查询的上下文节点，也就是在指定
        // 节点下查找符合XPath 的节点。本例中的上下文节点是整个文档；第二个参数指定了XPath 表达式
        // 的返回类型
        Object result = expr.evaluate(document, XPathConstants.NODESET);
        System.out.println("查询作者为Neal Stephenson 的图书的标题：");
        NodeList list = (NodeList) result;
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println(list.item(i).getNodeValue());
        }
    }
}
