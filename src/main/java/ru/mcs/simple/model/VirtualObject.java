package ru.mcs.simple.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "VirtualObject")
public class VirtualObject {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "virtualObject", cascade = CascadeType.PERSIST)
    private List<VirtualData> virtualDataList;

    @OneToMany(mappedBy = "virtualObject")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<VirtualField> virtualFieldList;

    public VirtualObject() {
    }

    public VirtualObject(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VirtualData> getVirtualDataList() {
        return virtualDataList;
    }

    public void setVirtualDataList(List<VirtualData> virtualDataList) {
        this.virtualDataList = virtualDataList;
    }

    public List<VirtualField> getVirtualFieldList() {
        return virtualFieldList;
    }

    public void setVirtualFieldList(List<VirtualField> virtualFieldList) {
        this.virtualFieldList = virtualFieldList;
    }

    @Override
    public String toString() {
        return "VirtualObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
