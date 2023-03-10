package dev.vashist.movies.controller;

import dev.vashist.movies.entity.Movie;
import dev.vashist.movies.entity.Review;
import dev.vashist.movies.service.MovieService;
import dev.vashist.movies.service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    //COntroller
    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping(path = "/getAllMovies")
    public ResponseEntity<List<Movie>>  getAllMovies(){

        return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){

        return  new ResponseEntity<Optional<Movie>>(movieService.movieById(imdbId),HttpStatus.OK);
    }

    @PostMapping("/createReview")

    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(reviewService.
                createReview(payload.get("reviewBody"),payload.get("imdbId")),HttpStatus.CREATED);


    }



}
