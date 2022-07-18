package ru.mcs.simple.model;

import jakarta.persistence.*;

@Entity
@Table(name = "VirtualData")
public class VirtualData {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="virtual_object_id", referencedColumnName = "id")
    private VirtualObject virtualObject;

    @Column(name = "value0")
    private String value0;

    @Column(name = "value1")
    private String value1;

    @Column(name = "value2")
    private String value2;

    @Column(name = "value3")
    private String value3;

    @Column(name = "value4")
    private String value4;

    @Column(name = "value5")
    private String value5;

    @Column(name = "value6")
    private String value6;

    @Column(name = "value7")
    private String value7;

    @Column(name = "value8")
    private String value8;

    @Column(name = "value9")
    private String value9;

    @Column(name = "name")
    private String name;

    public VirtualData() {
    }

    public VirtualData(String name) {
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

    @Override
    public String toString() {
        return "VirtualData{" +
                "id=" + id +
                ", virtualObject=" + virtualObject +
                ", value0='" + value0 + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", value5='" + value5 + '\'' +
                ", value6='" + value6 + '\'' +
                ", value7='" + value7 + '\'' +
                ", value8='" + value8 + '\'' +
                ", value9='" + value9 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
