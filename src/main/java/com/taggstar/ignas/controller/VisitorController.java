package com.taggstar.ignas.controller;

import com.taggstar.ignas.exception.VisitorNotFoundException;
import com.taggstar.ignas.model.Visitor;
import com.taggstar.ignas.service.VisitorService;
import com.taggstar.ignas.wrapper.VisitorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping(path = "/visitor/{id}", method = RequestMethod.GET)
    public ResponseEntity<VisitorWrapper> getVisitorById(@PathVariable Integer id) throws VisitorNotFoundException {
        VisitorWrapper visitor = visitorService.getById(id);
        return new ResponseEntity<>(visitor, HttpStatus.OK);
    }

    @RequestMapping(path = "/visitors", method = RequestMethod.GET)
    public ResponseEntity <List<VisitorWrapper>> getFilteredVisitors(
            @RequestParam(value = "dim1", required=false) String dim1,
            @RequestParam(value = "dim2", required=false) Integer dim2,
            @RequestParam(value = "dim3", required=false) String dim3,
            @RequestParam(value = "dim4", required=false) Integer dim4){

       List<VisitorWrapper> list =  visitorService.getFilteredVisitors(dim1, dim2, dim3, dim4);
       return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(path = "/visitor", method = RequestMethod.PUT,  headers="Accept=application/json")
    public ResponseEntity updateVisitor(@RequestBody Visitor visitor) throws VisitorNotFoundException {
        visitorService.updateVisitor(visitor);
        return new ResponseEntity( HttpStatus.OK);
    }


}
