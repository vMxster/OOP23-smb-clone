package it.unibo.model.tiles;

import org.w3c.dom.NodeList;

/**
 * The DocumentExtractor interface declares methods to extract information about the structure of a document.
 * It provides methods to retrieve the number of rows and columns in the document.
 */
public interface DocumentExtractor {

    /**
     * Retrieves the number of rows in the document.
     *
     * @return the number of rows in the document
     */
    int getNumRows();

    /**
     * Retrieves the number of columns in the document.
     *
     * @return the number of columns in the document
     */
    int getNumColumns();

    /**
     * Retrieves the elements associated with a TagName.
     *
     * @return the elements associated with a TagName.
     */
    NodeList getElements(final String tagName);

}

