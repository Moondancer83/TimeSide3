package hu.kalee.timeside.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * TimeSession.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */
@Entity
public class TimeSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long start;
    private Long end;
    private Boolean open;
    @ManyToOne
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(final Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(final Long end) {
        this.end = end;
    }

    public Boolean isOpen() {
        return open;
    }

    public void setOpen(final Boolean open) {
        this.open = open;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }
}
