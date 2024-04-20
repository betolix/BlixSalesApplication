package io.h3llo.blixsales.exception;

import java.time.LocalDateTime;


public record CustomErrorResponse(

        LocalDateTime datetime,
        String message,
        String path

) {



}
