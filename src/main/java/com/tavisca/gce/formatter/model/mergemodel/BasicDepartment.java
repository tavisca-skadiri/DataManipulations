package com.tavisca.gce.formatter.model.mergemodel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "department")
public class BasicDepartment implements Serializable {
    @Id
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BasicDepartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
