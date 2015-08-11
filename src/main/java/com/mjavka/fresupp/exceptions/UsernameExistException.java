package com.mjavka.fresupp.exceptions;

/**
 *
 * @author mjavka
 */
public class UsernameExistException extends RuntimeException
{
    UsernameExistException(String message)
    {
        super(message);
    }
}
