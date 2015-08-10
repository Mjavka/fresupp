package com.mjavka.fresupp.actions.exceptions;

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
