package com.mentoring.amarchuk.tickets.model;


public class Ticket {

    private Long id;
    private Long eventId;
    private Long userId;
    private Category category;
    private Integer place;

    public Ticket() {
    }

    public Ticket(Long eventId, Long userId, Category category, Integer place) {
        this.eventId = eventId;
        this.userId = userId;
        this.category = category;
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String toString() {
        return "TicketImpl: " +
                "id=" + id +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", category=" + category +
                ", place=" + place;
    }
}
