/**
 * 
 */
package com.Algorithm.Basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author aberehamwodajie
 *
 * Apr 11, 2017
 */
public class exam2 {
	
	//Sidi code:

	private static PriorityQueue<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies,Set<Integer> visited,Comparator<Movie> movieComparator) {
	        
			PriorityQueue<Movie> recommendations = new PriorityQueue<Movie>();
			for (Movie m : movie.getSimilarMovies()) {
				if (!visited.contains(m.getId())) {
					recommendations.add(m);
					visited.add(m.getId());
					recommendations.addAll(getMovieRecommendations(m, numTopRatedSimilarMovies, visited, movieComparator));
				}
			}
			
	        return subQueue(recommendations, numTopRatedSimilarMovies, movieComparator);
	    };
	    private static PriorityQueue<Movie> subQueue(PriorityQueue<Movie> movies, int numTopRatedSimilarMovies, Comparator<Movie> movieComparator)
	    {
	    	PriorityQueue<Movie> ms = new PriorityQueue<Movie>(movieComparator);
	    	for (int i = 0; i < numTopRatedSimilarMovies; i++) {
				if (movies.isEmpty())
					break;
				ms.add(movies.poll());
			}
	    	return ms;
	    }
	 public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
	        Set<Integer> visited = new HashSet<Integer>();
	        
			visited.add(movie.getId());
	    
	    Comparator<Movie> movieComparator = new Comparator<Movie>() {

				@Override
				public int compare(Movie m1, Movie m2) {
					// TODO Auto-generated method stub
					return Float.compare(m1.getRating(), m2.getRating());
				}
			};
	        return new ArrayList<Movie>(getMovieRecommendations(movie, numTopRatedSimilarMovies, visited,movieComparator));
	    }

}
