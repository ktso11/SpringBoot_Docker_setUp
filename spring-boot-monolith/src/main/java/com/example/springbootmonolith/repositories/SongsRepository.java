package com.example.springbootmonolith.repositories;

import com.example.springbootmonolith.models.Songs;
import org.springframework.data.repository.CrudRepository;

public interface  SongsRepository  extends CrudRepository<Songs, Long> {
}

