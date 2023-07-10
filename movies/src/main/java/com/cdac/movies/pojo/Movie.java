package com.cdac.movies.pojo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;


@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	private ObjectId id;
	
	private String imdbId;
	
	private String title;
	
	private String releasDate;
	
	private String trailerLink;
	
	private String poster;
	
	private List<String> genres;
	
	private List<String> backdrops;
	
	@DocumentReference
	private List<Review> reviewIds;

	public ObjectId getId() {
		return id;
	}
	
	public Movie() {
		
	}
	
	public Movie(ObjectId id, String imdbId, String releaseDate, String trailerLink, String poster,
			List<String> genres, List<String> bacldrops, List<Review> reviewIds) {
		this.id = id;
		this.imdbId = imdbId;
		this.title = title;
		this.releasDate = releaseDate;
		this.trailerLink = trailerLink;
		this.poster = poster;
		this.genres = genres;
		this.backdrops = backdrops;
		this.reviewIds = reviewIds;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleasDate() {
		return releasDate;
	}

	public void setReleasDate(String releasDate) {
		this.releasDate = releasDate;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getBackdrops() {
		return backdrops;
	}

	public void setBackdrops(List<String> backdrops) {
		this.backdrops = backdrops;
	}

	public List<Review> getReviewIds() {
		return reviewIds;
	}

	public void setReviewIds(List<Review> reviewIds) {
		this.reviewIds = reviewIds;
	}

}
