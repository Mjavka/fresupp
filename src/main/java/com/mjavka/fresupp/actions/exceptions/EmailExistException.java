package com.mjavka.fresupp.actions.exceptions;

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
