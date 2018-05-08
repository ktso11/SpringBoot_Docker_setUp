package com.example.springbootmonolith.controllers;

import com.example.springbootmonolith.models.Songs;
import com.example.springbootmonolith.repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongsController {
    @Autowired
    private SongsRepository SongsRepository;

    @GetMapping("/songs")
    public Iterable<Songs> findAllSongs() {
        return SongsRepository.findAll();
    }

    @GetMapping("/songs/{songsId}")
    public Optional<Songs> findSongById(@PathVariable Long songId) {
        return SongsRepository.findById(songId);
    }
    @DeleteMapping("/songs/{songId}")
    public HttpStatus deleteSongById(@PathVariable Long songId) {
        SongsRepository.deleteById(songId);
        return HttpStatus.OK;
    }

    @PostMapping("/songs")
    public Songs createNewSong(@RequestBody Songs newSong) {
        return SongsRepository.save(newSong);
    }

    @PatchMapping("/songs/{songsId}")
    public Songs updateSongById(@PathVariable Long songId, @RequestBody Songs songsRequest) {

        Songs songFromDb = SongsRepository.findById(songId).get();

        songFromDb.setSongName(songsRequest.getSongName());
        songFromDb.setArtist(songsRequest.getArtist());

        return SongsRepository.save(songFromDb);
    }
}




