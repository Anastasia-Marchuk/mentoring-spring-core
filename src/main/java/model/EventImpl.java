package model;

import java.util.Date;
import java.util.List;
import java.util.Objects;


public class EventImpl implements Event {

    private long Id;
    private String title;
    private Date date;

    public EventImpl(Long id,String title, Date date) {
        this.Id = id;
        this.title = title;
        this.date = date;
    }

    public EventImpl() {
    }

    @Override
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventImpl)) return false;
        EventImpl event = (EventImpl) o;
        return getId() == event.getId() &&
                Objects.equals(getTitle(), event.getTitle()) &&
                Objects.equals(getDate(), event.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDate());
    }




    @Override
    public String toString() {
        return "EventImpl: " +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", date=" + date;
    }
}
