package com.zero.kabelo.artifacts;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Kilobytes on 2016/09/05.
 */
@Entity
public class Login implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String dateTimeStamp;
    private String session;
    private Boolean authenticated;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public Login() {
    }

    public Login(User user) {
        this.user = user;
        this.dateTimeStamp = new Date().toString();
        this.session = java.util.UUID.randomUUID().toString();
        this.authenticated = true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(String dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public String getSessionId() {
        return session;
    }

    public void setSessionId(String sessionId) {
        this.session = sessionId;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
