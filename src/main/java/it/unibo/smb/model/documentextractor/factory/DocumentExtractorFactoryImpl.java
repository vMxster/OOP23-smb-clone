package it.unibo.smb.model.documentextractor.factory;

import it.unibo.smb.model.documentextractor.DocumentExtractor;
import it.unibo.smb.model.documentextractor.DocumentExtractorImpl;

/**
 * A factory implementation for creating instances of DocumentExtractor.
 * This implementation provides a method to create a document extractor
 * with the given TMX file.
 */
public class DocumentExtractorFactoryImpl implements DocumentExtractorFactory {

    @Override
    public final DocumentExtractor createDocumentExtractor(final String tmx) {
        return new DocumentExtractorImpl(tmx);
    }

}
