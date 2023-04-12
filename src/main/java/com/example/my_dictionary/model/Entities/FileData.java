package com.example.my_dictionary.model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "file_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "size")
    private Long size;
    @Column(name = "upload_time")
    private Date uploadTime;
    @JsonIgnore
    private byte[] content;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="FileDataId")
    private ManagerFileData managerFileData;
}
