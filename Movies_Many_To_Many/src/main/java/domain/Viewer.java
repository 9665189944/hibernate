package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "viewer")
public class Viewer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "viewer_id")
    private int viewerId;

    @Column(name = "viewer_name")
    private String  viewerName;

    @OneToMany(mappedBy = "viewerRef",cascade = CascadeType.ALL)
    Set<Rating> ratingSet;


    public int getViewerId() {
        return viewerId;
    }

    public void setViewerId(int viewerId) {
        this.viewerId = viewerId;
    }

    public String getViewerName() {
        return viewerName;
    }

    public void setViewerName(String viewerName) {
        this.viewerName = viewerName;
    }

    public Set<Rating> getRatingSet() {
        return ratingSet;
    }

    public void setRatingSet(Set<Rating> ratingSet) {
        this.ratingSet = ratingSet;
    }

    public  void  viewerR(Rating rating1)
    {
        if(ratingSet==null)
        {
            ratingSet=new HashSet<>();//upcasting because
        }
        ratingSet.add(rating1);
        rating1.setViewerRef(this);
    }
}
