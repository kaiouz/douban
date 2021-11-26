create table if not exists `user` (
    `id` varchar(32) not null,
    `nickname` varchar(255) not null,
    primary key (`id`)
);
