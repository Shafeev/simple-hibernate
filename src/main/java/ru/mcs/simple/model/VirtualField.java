package ru.mcs.simple.model;

import jakarta.persistence.*;

@Entity
@Table(name = "VirtualField")
public class VirtualField {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fieldName")
    private String fieldName;

    @Column(name = "dataType")
    private String dataType;

    @Column(name = "indexed")
    private boolean indexed;

    @Column(name = "fieldNum")
    private int fieldNum;

    @ManyToOne
    @JoinColumn(name="virtual_object_id", referencedColumnName = "id")
    private VirtualObject virtualObject;

    public VirtualField() {
    }

    public VirtualField(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getId() {
        return id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }

    @Override
    public String toString() {
        return "VirtualField{" +
                "id=" + id +
                ", fieldName='" + fieldName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", indexed=" + indexed +
                ", fieldNum=" + fieldNum +
                '}';
    }
}
