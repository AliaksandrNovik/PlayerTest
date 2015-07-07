package vmn.simpleTest.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.BasicConfigurator;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import vmn.simpleTest.constant.VmnConstant;
import vmn.simpleTest.listener.Listener;

public class RunnerTest {
	public RunnerTest(String[] args) {
		@SuppressWarnings("rawtypes")
		List<Class> listOfListeners = new ArrayList<Class>();
		listOfListeners.add(Listener.class);
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		BasicConfigurator.configure();
		TestNG testng = new TestNG();
		testng.setXmlSuites((List<XmlSuite>) (new Parser(VmnConstant.FILENAME_XML_SUITE).parse()));
		testng.run();
	}
}
