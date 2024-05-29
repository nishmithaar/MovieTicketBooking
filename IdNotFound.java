package com.example.MovieTicket.MovieBooking.Exceptions;

public class IdNotFound extends RuntimeException {
    public IdNotFound(String message) {
        super(message);
    }
}