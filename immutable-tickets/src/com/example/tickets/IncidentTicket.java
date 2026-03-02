package com.example.tickets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - mutable fields
 * - multiple constructors
 * - public setters
 * - tags list can be modified from outside
 * - validation is scattered elsewhere
 *
 * TODO (student): refactor to immutable + Builder.
 */
public class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final String priority;       // LOW, MEDIUM, HIGH, CRITICAL
    private final List<String> tags;     // mutable leak
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;    // optional
    private final String source;         // e.g. "CLI", "WEBHOOK", "EMAIL"

    public IncidentTicket() {
        this.tags = new ArrayList<>();
    }

    public IncidentTicket(String id, String reporterEmail, String title) {
        this();
        this.id = id;
        this.reporterEmail = reporterEmail;
        this.title = title;
    }

    public IncidentTicket(String id, String reporterEmail, String title, String priority) {
        this(id, reporterEmail, title);
        this.priority = priority;
    }

    // Getters
    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    } // BROKEN: leaks internal list
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    /*// Setters (BROKEN: should not exist after refactor)
    public void setId(String id) { this.id = id; }
    public void setReporterEmail(String reporterEmail) { this.reporterEmail = reporterEmail; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPriority(String priority) { this.priority = priority; }
    public void setTags(List<String> tags) { this.tags = tags; } // BROKEN: retains external reference
    public void setAssigneeEmail(String assigneeEmail) { this.assigneeEmail = assigneeEmail; }
    public void setCustomerVisible(boolean customerVisible) { this.customerVisible = customerVisible; }
    public void setSlaMinutes(Integer slaMinutes) { this.slaMinutes = slaMinutes; }
    public void setSource(String source) { this.source = source; }*/

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }

    static class Builder {
        private String id;
        private String reporterEmail;
        private String title;
        private String description;
    }
}
