drop if exists `douban`;
create database `douban` character set = utf8mb4;


drop table `user` if exists;
create table `user` if not exists (
    `id` varchar(32) not null,
    `nickname` varchar(255) not null,
    primary key (`id`)
) ENGINE = InnoDB;

drop table `person` if exists;
create table `person` if not exists (
    `id` int not null,
    `name` varchar(255) not null,
    `name_en` varchar(255),
    `name_zh` varchar(255),
    `birth` timestamp,
    `birthplace` varchar(255),
    `constellatory` varchar(255),
    `profession` varchar(255),
    `biography` varchar(500),
    primary key (`id`)
) ENGINE = InnoDB;

drop table `movie` if exists;
create table `movie` if not exists (
    `id` int not null,
    `name` varchar(255) not null,
    `alias` varchar(255),
    `cover` varchar(255),
    `score` float,
    `votes` int,
    `genres` varchar(255),
    `imdb_id` varchar(10),
    `languages` varchar(255),
    `mins` int,
    `official_site` varchar(255),
    `regions` varchar(255),
    `release_date` timestamp,
    `storyline` varchar(300),
    `tags` varchar(255),
    `year` year,
    primary key (`id`)
) ENGINE = InnoDB;

drop table  `movie_actor` if exists;
create table `movie_actor` if not exists (
    `movie_id` int not null,
    `actor_id` int not null,
    primary key (`movie_id`, `actor_id`)
) ENGINE = InnoDB;

drop table `movie_director` if exists;
create table `movie_director` if not exists (
    `movie_id` int not null,
    `director_id` int not null,
    primary key(`movie_id`, `director_id`)
) ENGINE = InnoDB;

drop table `comment` if exists;
create table `comment` if not exists (
    `id` int not null,
    `user_id` varchar(32),
    `movie_id` int,
    `content` varchar(300),
    `votes` int,
    `comment_time` timestamp,
    `rating` float,
    primary key (`id`)
) ENGINE = InnoDB;
