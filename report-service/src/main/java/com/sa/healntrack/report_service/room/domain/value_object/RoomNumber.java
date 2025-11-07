package com.sa.healntrack.report_service.room.domain.value_object;

import java.util.regex.Pattern;

public record RoomNumber(String value) {
    
    private static final Pattern ROOM_NUMBER_PATTERN = Pattern.compile("^(?=.{1,10}$)\\d.*[A-Z]?$");
    
    public RoomNumber {
        if (value == null) {
            throw new IllegalArgumentException("El numero de la habitacion no puede ser nulo");
        }
        final String roomNumberNormalized = value.toUpperCase();
        if (!ROOM_NUMBER_PATTERN.matcher(roomNumberNormalized).matches()) {
            throw new IllegalArgumentException(
                    "El numero de habitacion debe tener uno o mas digitos y puede terminar con una letra mayuscula");
        }
        value = roomNumberNormalized;
    }

}
