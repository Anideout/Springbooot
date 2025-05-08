package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alumno;
import com.example.demo.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired 
    private AlumnoService alumnoService;

    @PostMapping
    public String almacenar(@RequestBody Alumno alumno) {
        return alumnoService.almacenar(alumno);
    }
    @GetMapping
    public List<Alumno> listar() {
        return alumnoService.listar();
    }

}
