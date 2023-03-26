package com.example.hw50.controller;

import com.example.hw50.dto.PublicationDto;
import com.example.hw50.entity.Publication;
import com.example.hw50.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
@RequiredArgsConstructor
public class PublicationController {
    private final PublicationService publicationsService;

    @GetMapping("/takePublicationForUser/{userId}")
    public ResponseEntity<List<PublicationDto>>  takePublicationsForUser(@PathVariable String userId){
        return new ResponseEntity<>(publicationsService.getPublicationForUser(Integer.parseInt(userId)), HttpStatus.OK);
    }
    @GetMapping("/takePublicationsForUserBySubscriptions/{userId}")
    public ResponseEntity<List<PublicationDto>> takePublicationsForUserBySubscriptions(@PathVariable String userId){
        return new ResponseEntity<>(publicationsService.getPublicationsForUserBySubscriptions(Integer.parseInt(userId)), HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PublicationDto addPublication(@RequestBody PublicationDto publicationDto){
        return publicationsService.addPublication(publicationDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        if (publicationsService.deletePublication(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
