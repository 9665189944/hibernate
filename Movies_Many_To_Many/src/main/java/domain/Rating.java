package domain;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "rating_id")
    private int ratingId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="movie_ref")
    private Movie movieRef;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="viewer_ref")
    private Viewer viewerRef;

    @Column(name = "rating")
    private double ratings;

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public Movie getMovieRef() {
        return movieRef;
    }

    public void setMovieRef(Movie movieRef) {
        this.movieRef = movieRef;
    }

    public Viewer getViewerRef() {
        return viewerRef;
    }

    public void setViewerRef(Viewer viewerRef) {
        this.viewerRef = viewerRef;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }
}
