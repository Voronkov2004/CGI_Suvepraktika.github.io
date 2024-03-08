package com.example.CGI.repository;

import com.example.CGI.models.Films;
import org.springframework.data.repository.CrudRepository;

public interface FilmsRepository extends CrudRepository<Films, Long> {

}
