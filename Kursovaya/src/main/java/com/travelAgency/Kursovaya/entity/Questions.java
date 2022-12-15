package com.travelAgency.Kursovaya.entity;

import javax.persistence.*;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String text;
    private String bodyPart;
    private String illness;
    private String var1;
    private String var2;
    private String var3;

    public Questions() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public Questions(String text, String bodyPart, String illness, String var1, String var2, String var3) {
        this.text = text;
        this.bodyPart = bodyPart;
        this.illness = illness;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
    }
}
