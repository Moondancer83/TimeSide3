package hu.kalee.timeside.controller;


import java.util.Date;

/**
 * TimeDto.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */
public class TimeDto {
    private Long id;
    private Date start;
    private Date end;
    private Boolean open;

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setStart(final Date start) {
        this.start = start;
    }

    public Date getStart() {
        return start;
    }

    public void setEnd(final Date end) {
        this.end = end;
    }

    public Date getEnd() {
        return end;
    }

    public void setOpen(final Boolean open) {
        this.open = open;
    }

    public Boolean getOpen() {
        return open;
    }
}
