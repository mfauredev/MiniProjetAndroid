package fr.m2dl.miniprojet;

import java.io.InputStream;
        import java.util.List;
        import javax.xml.parsers.SAXParserFactory;
        import org.xml.sax.InputSource;
        import org.xml.sax.XMLReader;
        import android.util.Log;

import fr.m2dl.miniprojet.domain.Type;

public class SAXXMLParser {
    public static List<Type> parse(InputStream is) {
        List<Type> employees = null;
        try {
            // create a XMLReader from SAXParser
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser()
                    .getXMLReader();
            // create a SAXXMLHandler
            SAXXMLHandler saxHandler = new SAXXMLHandler();
            // store handler in XMLReader
            xmlReader.setContentHandler(saxHandler);
            // the process starts
            xmlReader.parse(new InputSource(is));
            // get the `Employee list`
            employees = saxHandler.getTypeList();

        } catch (Exception ex) {
            Log.e("XML", "SAXXMLParser: parse() failed", ex);
        }

        // return Employee list
        return employees;
    }
}