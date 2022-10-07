package com.ticket.app.model.controller;

import com.ticket.app.model.Data;
import com.ticket.app.model.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class TicketApi {

    @Autowired
    private DataRepository dataRepository;

    @RequestMapping(path = "/submit", method = RequestMethod.POST)
    public String sendMessage(@RequestBody Data data){
        dataRepository.save(data);
        return "sent";
    }
    @RequestMapping(path = "/allmessages", method = RequestMethod.GET)
    public Iterable<Data>  getAllMessages(){
        return dataRepository.findAll();
    }

    @RequestMapping(path = "/ticket/{id}", method = RequestMethod.GET)
    Optional<Data> getData(@PathVariable("id") Integer id) {
        Optional<Data> i = dataRepository.findById(id);
        return i;
    }

    @PutMapping(path = "/addcomment/{id}")
    Data updateComment(@PathVariable("id") Integer id, @RequestBody Data data) {
        System.out.println(data.toString());
        Data existingData=dataRepository.findById(id).get();
        existingData.updateComment(data.getComment());
        dataRepository.save(existingData);
        return existingData;
    }
}