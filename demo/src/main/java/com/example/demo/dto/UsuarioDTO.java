package com.example.demo.dto;

public class UsuarioDTO {
    private String correo;
    private String nombre;
    private String apellido;

    public UsuarioDTO() {}

    public UsuarioDTO(String correo, String nombre, String apellido) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    

    /**
     * @return String return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
