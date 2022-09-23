package com.ezest.dhis2.portal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter @ToString
@Entity
@Table(name = "dataelement")
public class DataElement implements Serializable {

    private static final long serialVersionUID = -2343243243242432341L;

    @Id
    @Column(name = "dataelementid")
    private String dataelementid;

    @Column(name = "name")
    private String name;

    @Column(name = "shortname")
    private String shortName;

    @Column(name = "code")
    private String code;
}
