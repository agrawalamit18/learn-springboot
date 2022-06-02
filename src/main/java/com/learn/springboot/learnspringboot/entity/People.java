package com.learn.springboot.learnspringboot.entity;

import com.learn.springboot.learnspringboot.event.listener.AuditListener;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

@Entity
@EntityListeners(AuditListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table (name = "people", schema = "NewApp")
public class People {
    private static Log log = LogFactory.getLog(AuditListener.class);
    @Id
    private int id;

    @Column (name = "user_name", length = 50, nullable = false, unique = true)
    private String userName;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private PeopleContact contact;

    @Embedded
    private PeopleE peopleContact;

   // @OneToMany (targetEntity = PeopleFamily.class)
   // private Set<PeopleFamily> family;

    @Transient
    private boolean member;

    @Transient
    private String uniqueId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private enum Gender {
        MALE,
        FEMALE
    }

    @PrePersist
    public void logNewUserAttempt() {
    }

    @PostPersist
    public void logNewUserAdded() {
    }

    @PreRemove
    public void logUserRemovalAttempt() {
    }

    @PostRemove
    public void logUserRemoval() {
    }

    @PreUpdate
    public void logUserUpdateAttempt() {
    }

    @PostUpdate
    public void logUserUpdate() {
    }

    @PostLoad
    public void logUserLoad() {
        uniqueId = id+":"+ userName;
        log.info("Loading data : ");
    }
}