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

    public Boolean isOpen() {
        return open;
    }

    /**
     * Calculate length of session
     * TODO: refactor to return a string [dd] hh:mm
     *
     * @return length of session in hours
     */
    public double diff() {
        Date endDate = this.end;
        if (end == null) {
            endDate = new Date();
        }
        double hours = (endDate.getTime() - start.getTime()) / (double) (60 * 60 * 1000);
        return Math.round(hours * 100) / 100d;
    }
}
