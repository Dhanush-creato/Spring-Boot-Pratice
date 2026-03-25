package org.springexmaples.firstspringboot;

public class HelloProgramWithGetterAndSetter {
    String message ;


    public String getMessage() {
        return message;
    }

    public HelloProgramWithGetterAndSetter setMessage(String message) {
        this.message = message;
        return this;
    }

    public HelloProgramWithGetterAndSetter(String message) {
        this.message = message;
    }
}
