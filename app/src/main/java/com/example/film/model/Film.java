package com.example.film.model;

public class Film {
    private int id;
    private String name;
    private String idFilm;
    private String idPlaylist;
    private String duration;
    private String date;
    private String countLike;
    private String countDisLike;
    private String countSeen;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Film(int id, String name, String idFilm, String idPlaylist, String duration, String date, String countLike, String countDisLike, String countSeen, String description) {
        this.id = id;
        this.name = name;
        this.idFilm = idFilm;
        this.idPlaylist = idPlaylist;
        this.duration = duration;
        this.date = date;
        this.countLike = countLike;
        this.countDisLike = countDisLike;
        this.countSeen = countSeen;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(String idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountLike() {
        return countLike;
    }

    public void setCountLike(String countLike) {
        this.countLike = countLike;
    }

    public String getCountDisLike() {
        return countDisLike;
    }

    public void setCountDisLike(String countDisLike) {
        this.countDisLike = countDisLike;
    }

    public String getCountSeen() {
        return countSeen;
    }

    public void setCountSeen(String countSeen) {
        this.countSeen = countSeen;
    }
}
