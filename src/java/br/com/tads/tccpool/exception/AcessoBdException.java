/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tads.tccpool.exception;

/**
 *
 * @author onurb
 */
public class AcessoBdException extends Exception{
    public AcessoBdException () {
    }

    public AcessoBdException (String message) {
        super(message);
    }

    public AcessoBdException (String message, Throwable cause) {
        super(message, cause);
    }
}
