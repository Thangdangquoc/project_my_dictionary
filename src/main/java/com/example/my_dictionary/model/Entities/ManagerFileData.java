package com.example.my_dictionary.model.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "manager_file_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerFileData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "filePath")
    private String filePath;
    @Column(name = "upload_time")
    private Date uploadTime;
}
