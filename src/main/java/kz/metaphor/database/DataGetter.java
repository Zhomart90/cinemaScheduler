package kz.metaphor.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kz.metaphor.model.Movie;

@Repository
@Qualifier(value = "dataGetter")
public class DataGetter {
	Connection connection;

	public List<Movie> getMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from movies";
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setProducer(rs.getString("producer"));
				movie.setDate(rs.getDate("date"));
				movies.add(movie);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return movies;
	}

	public List<Movie> getMoviesByDate(String date) {
		List<Movie> movies = new ArrayList<Movie>();
		String sql = "select * from movies where date = '" + date + "'";
		System.out.println("sql: " + sql);
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setName(rs.getString("name"));
				movie.setProducer(rs.getString("producer"));
				movie.setDate(rs.getDate("date"));
				movies.add(movie);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return movies;
	}

}
