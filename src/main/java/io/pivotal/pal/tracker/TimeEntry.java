package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private Long id;
    private Long projectId;
    private Long userId;
    private LocalDate date;
    private Integer hours;

    public TimeEntry(Long projectId, Long userId, LocalDate parse, Integer i) {
         this.projectId = projectId;
         this.userId = userId;
         this.date = parse;
         this.hours = i;
    }

    public TimeEntry(Long timeEntryId, Long projectId, Long userId, LocalDate parse, Integer i) {
        this(projectId, userId, parse, i);
        this.id=timeEntryId;
    }

    public TimeEntry() {
        this(null, null, null, null);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return Objects.equals(id, timeEntry.id) &&
                Objects.equals(projectId, timeEntry.projectId) &&
                Objects.equals(userId, timeEntry.userId) &&
                Objects.equals(date, timeEntry.date) &&
                Objects.equals(hours, timeEntry.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }
}
