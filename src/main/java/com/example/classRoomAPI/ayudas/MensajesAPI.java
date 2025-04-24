package com.example.classRoomAPI.ayudas;

public enum MensajesAPI {
    ERROR_DOCENTE_NO_ENCONTRADO("El docente que buscas, no esta en la base de datos"),
    ERROR_ESTUDUANTE_NO_ENCONTARDO("El ustudiante no esta, perro!!!.")
    ;

    private String mensaje;

    MensajesAPI(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
