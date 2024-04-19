package io.h3llo.blixsales.dto;

import java.util.List;

public record GenericResponseRecord<T>(

        int status,
        String message,
        List<T>data
) {

}
