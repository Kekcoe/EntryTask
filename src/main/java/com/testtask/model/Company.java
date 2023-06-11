package com.testtask.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="companies")
public class Company extends BaseEntity{

    /**Имя*/
    private String name;

    /**Правовая форма*/
    private String legalForm;

    /**Адрес*/
    private String adress;

    /**Филиалы*/
    private String branches;

    public Company() {

    }

    public Company(String name, String legalForm, String adress, String branches) {
        super();
        this.name = name;
        this.legalForm = legalForm;
        this.adress = adress;
        this.adress = branches;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
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
