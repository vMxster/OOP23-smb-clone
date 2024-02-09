package it.unibo.model.tiles;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DocumentExtractorImpl implements DocumentExtractor {

    private final String tmx;
    private Document document;
    private int numRows;
    private int numColumns;

    public DocumentExtractorImpl(final String tmx) {
        this.tmx = tmx;
		extractDocument();
    }

    private void extractDocument() {
        try {
            this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(this.tmx);
            NodeList mapAttributes = this.getElements("map");
            if (mapAttributes.getLength() > 0) {
                this.numRows = Integer.parseInt(((Element) mapAttributes.item(0)).getAttribute("height"));
                this.numColumns = Integer.parseInt(((Element) mapAttributes.item(0)).getAttribute("width"));
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public NodeList getElements(String tagName) {
        return this.document.getElementsByTagName(tagName);
    }

    @Override
    public int getNumRows() {
        return this.numRows;
    }

    @Override
    public int getNumColumns() {
        return this.numColumns;
    }

}
