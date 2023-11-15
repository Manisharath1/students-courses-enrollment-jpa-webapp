package com.course.reg.exception;

public class ValidatorException extends RuntimeException {

       private static final long serialVersionUID = 1L;

       /**
       * Method which shows Validator Exception
       */

       public ValidatorException() {
              super();
       }

       /**
       * Method which shows Validator Exception with exception passed as param
       *
        * @param t
       */
       public ValidatorException(Throwable t) {
              super(t);
       }
       /**
       * Method which shows Validator Exception with message passed as param
       *
        * @param message
       */
       public ValidatorException(String message) {
              super(message);
       }
}

 