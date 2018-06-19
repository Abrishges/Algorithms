package com.Algorithm.Basic;

import java.util.List;
import java.util.Set;

public class ExamAmazonee2 {

  private static Set<Movie> getMovieRecommendations(final Movie movie, final int N) {
    // Write your code here


  }

  public class Movie {
    private int id;
    private float rating;
    private List<Movie> similarMovies;

    public int getId() {
      return this.id;
    }

    public void setId(final int id) {
      this.id = id;
    }

    public float getRating() {
      return this.rating;
    }

    public void setRating(final float rating) {
      this.rating = rating;
    }

    public List<Movie> getSimilarMovies() {
      return this.similarMovies;
    }

    public void setSimilarMovies(final List<Movie> similarMovies) {
      this.similarMovies = similarMovies;
    }
  }
}
