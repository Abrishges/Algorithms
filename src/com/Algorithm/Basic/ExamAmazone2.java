/**
 *
 */
package com.Algorithm.Basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author aberehamwodajie
 *
 *         Apr 11, 2017
 */
public class ExamAmazone2 {

  private static PriorityQueue<Movie> getMovieRecommendations(
      final Movie movie,
      final int numTopRatedSimilarMovies,
      final Set<Integer> visited,

      final Comparator<Movie> movieComparator) {

    final PriorityQueue<Movie> recommendations = new PriorityQueue<>();
    for (final Movie m : movie.getSimilarMovies()) {
      if (!visited.contains(m.getId())) {
        recommendations.add(m);
        visited.add(m.getId());
        recommendations.addAll(getMovieRecommendations(m, numTopRatedSimilarMovies, visited, movieComparator));
      }
    }

    return subQueue(recommendations, numTopRatedSimilarMovies, movieComparator);
  };

  private static PriorityQueue<Movie> subQueue(
      final PriorityQueue<Movie> movies,
      final int numTopRatedSimilarMovies,
      final Comparator<Movie> movieComparator) {
    final PriorityQueue<Movie> ms = new PriorityQueue<>(movieComparator);
    for (int i = 0; i < numTopRatedSimilarMovies; i++) {
      if (movies.isEmpty()) {
        break;
      }
      ms.add(movies.poll());
    }
    return ms;
  }

  public static List<Movie> getMovieRecommendations(final Movie movie, final int numTopRatedSimilarMovies) {
    final Set<Integer> visited = new HashSet<>();

    visited.add(movie.getId());

    final Comparator<Movie> movieComparator = new Comparator<Movie>() {

      @Override
      public int compare(final Movie m1, final Movie m2) {
        // TODO Auto-generated method stub
        return Float.compare(m1.getRating(), m2.getRating());
      }
    };
    return new ArrayList<>(getMovieRecommendations(movie, numTopRatedSimilarMovies, visited, movieComparator));
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
