package com.example.my_dictionary.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
public class Vocabulary implements Serializable {
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "transliteration")
    private String transliteration;

    @Column(name = "translate")
    private String translate;

    @Column(name = "Example")
    private String example;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

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
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "voca_cate",
            joinColumns = @JoinColumn(name = "vocabulary_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
}


