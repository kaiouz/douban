package io.github.kaiouz.douban.movie;

import io.github.kaiouz.douban.person.Person;

import java.time.LocalDate;
import java.util.List;

public class Movie {

    /**
     * id
     */
    private String id;

    /**
     * 电影名称
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 演员
     */
    private List<Person> actors;

    /**
     * 封面
     */
    private String cover;

    /**
     * 导演
     */
    private List<Person> directors;

    /**
     * 评分
     */
    private double score;


    private int votes;

    private List<String> genres;

    private String imdbId;

    /**
     * 语言
     */
    private List<String> languages;

    /**
     * 时长, 分钟
     */
    private int mins;

    /**
     * 官方网站
     */
    private String officialSite;

    /**
     * 地区
     */
    private List<String> regions;

    /**
     * 发布日期
     */
    private LocalDate releaseDate;

    /**
     * 故事内容
     */
    private String storyline;

    /**
     * 标签
     */
    private List<String> tags;

    /**
     * 上映年份
     */
    private int year;
}
