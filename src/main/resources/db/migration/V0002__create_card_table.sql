create table `card`
(
    `id`       char(36) not null,
    `card_name` varchar(100) default null,
    `create_at` timestamp default now(),
    primary key (`id`),
    index `cardNameIndex` (`card_name`),
    index `createAtIndex` (`create_at`)
);

create table `card_content`
(
    `card_id` char(36) not null,
    `content` nvarchar(100) default null
);