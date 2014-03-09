package com.habuma.spitter.mvc;

/**
 *
 * @author ralvarado
 */
public class ImageUploadException extends Exception {

    /**
     * Creates a new instance of <code>ImageUploadException</code> without
     * detail message.
     */
    public ImageUploadException() {
    }

    /**
     * Constructs an instance of <code>ImageUploadException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ImageUploadException(String msg) {
        super(msg);
    }
}
