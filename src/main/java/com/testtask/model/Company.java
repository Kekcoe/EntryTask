package com.testtask.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="companies")
public class Company extends BaseEntity{

    /**Имя*/
    private String name;

    /**Правовая форма*/
    private String legalform;

    /**Адрес*/
    private String adress;

    /**Филиалы*/
    private String branches;

    public Company() {

    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getLegalform() {
        return legalform;
    }

    public void setLegalform(String legalform) {
        this.legalform = legalform;
    }

    @NotNull
    public String getAdress() {
        return adress;
    }

    public void setAdress(@NotNull String adress) {
        this.adress = adress;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }
}
