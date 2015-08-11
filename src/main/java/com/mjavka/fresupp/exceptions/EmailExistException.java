package com.mjavka.fresupp.exceptions;

/**
 *
 * @author mjavka
 */
public class EmailExistException extends RuntimeException
{
    public EmailExistException(String message)
    {
        super(message);
    }
}
