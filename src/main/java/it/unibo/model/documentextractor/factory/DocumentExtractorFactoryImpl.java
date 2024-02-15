package it.unibo.model.documentextractor.factory;

import it.unibo.model.documentextractor.DocumentExtractor;
import it.unibo.model.documentextractor.DocumentExtractorImpl;

/**
 * Creates a new DocumentExtractor object based on the provided TMX (Tile Map XML).
 *
 * @param tmx the Tile Map XML data representing the document.
 * @return a DocumentExtractor object created with the provided TMX data.
 */
public class DocumentExtractorFactoryImpl implements DocumentExtractorFactory {

    @Override
    public final DocumentExtractor createDocumentExtractor(final String tmx) {
        return new DocumentExtractorImpl(tmx);
    }

}
