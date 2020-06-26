package com.learning.springboothibernate.bean.onetoonejointable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity(name="WORKER")
@Table

public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "worker_workstation",
            joinColumns =
                    { @JoinColumn(name = "worker_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "workstation_id", referencedColumnName = "id") })
    private WorkStation workStation;
}
