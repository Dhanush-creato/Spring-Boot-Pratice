package org.springexmaples.ecommerce.Category.Execption;

public class ApiExecption extends RuntimeException{


    public ApiExecption() {
    }

    public ApiExecption(String message) {
        super(message);

    }
}
