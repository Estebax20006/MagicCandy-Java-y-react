package com.MagicCandy.AppQuiromar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "novelties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Novelty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkid")
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "date", columnDefinition = "DATE")
    private Date date;

    @Column(name = "time", columnDefinition = "TIME")
    private Date time;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(targetEntity = Production.class)
    @JoinColumn(name = "fk_productions_id")
    private Production production;

    @ManyToOne(targetEntity = NoveltyStatus.class)
    @JoinColumn(name = "fk_noveltyStates_id")
    private NoveltyStatus noveltyStatus;

    @ManyToOne(targetEntity = Sender.class)
    @JoinColumn(name = "fk_senders_id")
    private Sender sender;

    @ManyToOne(targetEntity = Referred.class)
    @JoinColumn(name = "fk_referred_id")
    private Referred referred;
}
