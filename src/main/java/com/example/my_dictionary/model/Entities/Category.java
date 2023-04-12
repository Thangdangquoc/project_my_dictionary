package com.example.my_dictionary.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "vocabulary", uniqueConstraints = {
        @UniqueConstraint(columnNames = "Id")

})
@Getter
@Setter
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "symbol")
    private String symbol;
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Vocabulary> vocabularies = new HashSet<>();
    @JsonIgnore
    @Column(name = "create_time")
    private Date create_time = new Date();

    @JsonIgnore
    @Column(name = "modify_time")
    private Date modify_time = new Date();

    @JsonIgnore
    @Column(name = "createBy")
    private String createBy;

    @JsonIgnore
    @Column(name = "updateBy")
    private String updateBy;
}
