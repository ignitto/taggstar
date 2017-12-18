package com.taggstar.ignas.service;

import com.taggstar.ignas.exception.VisitorNotFoundException;
import com.taggstar.ignas.model.Visitor;
import com.taggstar.ignas.repository.VisitorRepository;
import com.taggstar.ignas.wrapper.VisitorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitorService {

    @Autowired
    private VisitorRepository repository;

    public VisitorWrapper getById(Integer id) throws VisitorNotFoundException {
        return repository.getVisitors().stream()
                .filter(v -> id.equals(v.getVisitorId()))
                .map(VisitorWrapper::new)
                .findFirst().orElseThrow( () -> new VisitorNotFoundException("Visitor not found"));
    }

    public List<VisitorWrapper> getFilteredVisitors(String dim1, Integer dim2, String dim3, Integer dim4){
        return repository.getVisitors().stream()
                .filter(v ->
                        compare(dim1, v.getDim1())
                            && compare(dim2, v.getDim2())
                                && compare(dim3, v.getDim3())
                                    && compare(dim4, v.getDim4()))
                .map(VisitorWrapper::new)
                .collect(Collectors.toList());
    }

    public void updateVisitor(Visitor visitor) throws VisitorNotFoundException {
        if(visitor.getVisitorId() == null){
            throw new VisitorNotFoundException("Visitor not found");
        }

        repository.getVisitors().forEach( v ->{
            if(visitor.getVisitorId().equals(v.getVisitorId())){
                v.setDim1(visitor.getDim1());
                v.setDim2(visitor.getDim2());
                v.setDim3(visitor.getDim3());
                v.setDim4(visitor.getDim4());
                v.setLabel(visitor.getLabel());
            }
        });
    }

    private boolean compare(Object obj1, Object obj2) {
        return obj1 == null || obj2 != null && obj1.equals(obj2);
    }
}
