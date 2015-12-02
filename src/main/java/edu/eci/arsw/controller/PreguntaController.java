package edu.eci.arsw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;
import edu.eci.arsw.model.*;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PreguntaController {
    
    private final ArrayList<String> usuarios = new ArrayList();
    {
        usuarios.add("Diego");
        usuarios.add("Daniela");
    }

    private final ArrayList<Pregunta> preguntas = new ArrayList();
    {
        preguntas.add(new Pregunta("Cultura","¿En que año piso por primera vez una persona la luna ?"));
        preguntas.add(new Pregunta("Historia","¿En que llegaron los vikingos a America?"));
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/usuarios")
    public ArrayList<String> getUsuarios() {
        return usuarios;
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/usuario")
    public  ResponseEntity<?>  postUsuario(@RequestBody String user) {
        usuarios.add(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/preguntas")
    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/pregunta")
    public  ResponseEntity<?>  postPregunta(@RequestBody Pregunta p) {
        preguntas.add(p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/pregunta")
     public void  deletePregunta(@RequestBody int ind) {  
        preguntas.remove(ind);   
    }
     
    @RequestMapping(method = RequestMethod.PUT,value = "/pregunta/{index}")
    public  List<Pregunta>  putEntry(@PathVariable int ind, @RequestBody Pregunta p) {
        preguntas.set(ind,p);
        return preguntas;
    }

}
