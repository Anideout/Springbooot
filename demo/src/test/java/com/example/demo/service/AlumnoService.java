package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Alumno;
import com.example.demo.model.Curso;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.CursoRepository;


@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public String almacenar(Alumno alumno) {
        if(alumnoRepository.findById(alumno.getRut()).isPresent()) {
            return "el alumno con rut: " + alumno.getRut() + " ya existe!";
        }

        alumnoRepository.save(alumno);
        return "alumno almacenado correctamente!";
    }

    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }

    // Metodo que asigna un alumno a un curso 
    public String alumnoAsignarCurso(String rut, String sigla) {
        
        // validar que el alumno y curso existan 
        if(!alumnoRepository.existsById(rut)) {
            return "alumno ingresado no existe!";
        }

        if(!cursoRepository.existsById(sigla)) {
        return "Curso ingresado no existe";
        }


        //obtenemos el curso y el alumno
        Curso curso = cursoRepository.findById(sigla).get();
        Alumno alumno = alumnoRepository.findById(rut).get();

        //validamos que el alumno no esté inscrito en ese curso
        if(alumno.getCursos().contains(curso)){
            return "El alumno ya está en ese curso XD ";
        }

        alumno.getCursos().add(curso);
        alumnoRepository.save(alumno);
        return "Curso asignado correctamente";
    }    
}
