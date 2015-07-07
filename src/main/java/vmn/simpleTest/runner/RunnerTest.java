package vmn.simpleTest.runner;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import vmn.simpleTest.constant.VmnConstant;

public class RunnerTest {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		TestNG testng = new TestNG();
		testng.setXmlSuites((List<XmlSuite>) (new Parser(VmnConstant.FILENAME_XML_SUITE).parse()));
		testng.run();
	}
}
