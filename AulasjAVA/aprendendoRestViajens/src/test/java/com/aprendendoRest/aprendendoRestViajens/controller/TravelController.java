package com.aprendendoRest.aprendendoRestViajens.controller;

import com.aprendendoRest.aprendendoRestViajens.model.Travel;
import com.aprendendoRest.aprendendoRestViajens.service.TravelService;
import lombok.var;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api-travels/travels")
public class TravelController {

    private static final Logger logger = Logger.getLogger(TravelController.class);

    @Autowired
    private TravelService travelService;
    @GetMapping
    public ResponseEntity<List<Travel>> find() {
        if (travelService.find().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        logger.info(travelService.find());
        return ResponseEntity.ok(travelService.find());
    }
    @DeleteMapping
    public ResponseEntity<Boolean> delete() {
        try {
            travelService.delete();;
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            logger.error(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping
    @ResponseBody
    public ResponseEntity<Travel> create(@ResponseBody JSONObject travel) {
        try {
            if (travelService.isJSONValid(travel.toString())) ;
            var uri = ServletUriComponentsBuilder.fromCurrentRequest().path(travelCreated.getOrderNumber()).build().toUri();
            if (travelService.isStartDateGreaterThanEndDate(travelCreated)) {
                logger.error("The start date is greater than end date.");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
            } else {
                travelService.add(travelCreated);
                return ResponseEntity.created(uri).body(null);
            } else{
                return ResponseEntity.badRequest().body(null);
            }
        }catch (Exception e) {
            logger.error("JSON fields are not parsable. " + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }
    @PutMapping(path = ";{id}", produces = { "application/json" })
    public ResponseEntity<Travel> update(@PathVariable("id") long id, @RequestBody JSONObject travel){
        try {
            if(travelService.isJSONValid(travel.toString())) {
                Travel travelToUpdate = travelService.findById(id);
                if(travelToUpdate == null){
                    logger.error("Travel not found.");
                    return ResponseEntity.notFound().build();
                }else {
                    Travel travelToUpdate = travelService.update(travelToUpdate, travel);
                    return ResponseEntity.ok(travelToUpdate);
                }
            }else {
                return ResponseEntity.badRequest().body(null);
            }
        }catch(Exception e) {
            logger.error("JSON fields are not parsable." + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
    }
}
