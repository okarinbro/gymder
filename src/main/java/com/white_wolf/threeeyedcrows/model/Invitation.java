package com.white_wolf.threeeyedcrows.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "invitation")
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_fk")
    private Set<User> sender;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_fk")
    private Set<User> receiver;
    private Timestamp timestamp;
    private boolean accepted;


    public Invitation() {
    }
}
