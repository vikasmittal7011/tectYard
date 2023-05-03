package com.techyard.feedback;

public class FeedBack {
    int id, age;
    String comment, name, email, contact;

    // Constructors
    public FeedBack(int id, int age, String comment, String name, String email, String contact) {
        this.id = id;
        this.age = age;
        this.comment = comment;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public FeedBack(String comment, String email) {
        this.comment = comment;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getComment() {
        return comment;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}