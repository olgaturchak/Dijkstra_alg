package com.company;

public enum SceneSpecification {
    YELLOW(1, "Yellow"), GREEN(5, "Green"), ORANGE(3, "Orange"), PINK(2, "Pink"),
    PURPLE(6, "Purple"), BLACK(4, "Black");

    int num;
    String color;

    SceneSpecification(int num, String color) {
        this.num = num;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

 }
