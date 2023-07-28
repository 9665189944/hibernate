package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "movie_id")
        private int movieId;
        @Column(name="movie_name")
        private String movieName;

        @OneToMany(mappedBy = "movieRef" ,cascade = CascadeType.ALL)
    private Set<Rating> ratingSet;

        public int getMovieId() {
                return movieId;
        }

        public void setMovieId(int movieId) {
                this.movieId = movieId;
        }

        public String getMovieName() {
                return movieName;
        }

        public void setMovieName(String movieName) {
                this.movieName = movieName;
        }

    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    public  void  movieR(Rating rating)
        {
            if(ratingSet==null)
                {
                    ratingSet=new HashSet<>();//upcasting because
                }
            ratingSet.add(rating);
            rating.setMovieRef(this);
        }

}
