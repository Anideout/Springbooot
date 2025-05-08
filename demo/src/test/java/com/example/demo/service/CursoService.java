package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;


//para que sea utilizada en el controlador
@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    

    //edutech
    public String almacenar(Curso curso){
        
        if(cursoRepository.findById(curso.getSigla()).isPresent()){
            return "La sigla" + curso.getSigla() + "Ya existe!! ";
        }

        cursoRepository.save(curso);
        return "Curso almacenado correctamente";
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    


}
