package it.unibo.model.documentextractor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.commons.Constants;
import it.unibo.model.documentextractor.factory.DocumentExtractorFactoryImpl;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit tests for DocumentExtractor class.
 */
public class TestDocumentExtractor {

    private static final int NUM_ROWS = 30;
    private static final int NUM_COLS = 36;
    private DocumentExtractor documentExtractor;

    /**
     * Initializes the test environment before each test method is executed.
     */
    @BeforeEach
    public void init() {
        this.documentExtractor = new DocumentExtractorFactoryImpl()
            .createDocumentExtractor(Constants.SOURCE_MAP);
        assertNotNull(this.documentExtractor);
    }

    /**
     * Test the {@link DocumentExtractor#getElements()} method.
     */
    @Test
    public void testGetElements() throws ParserConfigurationException {
        assertNotNull(this.documentExtractor.getElements(TagType.OBJECT));
        assertNotNull(this.documentExtractor.getElements(TagType.OBJECTGROUP));
        assertNotNull(this.documentExtractor.getElements(TagType.TILE));
    }

    /**
     * Test the {@link DocumentExtractor#getNumRows()} method.
     */
    @Test
    public void testGetNumRows() {
        assertEquals(NUM_ROWS, documentExtractor.getNumRows());
    }

    /**
     * Test the {@link DocumentExtractor#getNumColumns()} method.
     */
    @Test
    public void testGetNumColumns() {
        assertEquals(NUM_COLS, documentExtractor.getNumColumns());
    }

}
