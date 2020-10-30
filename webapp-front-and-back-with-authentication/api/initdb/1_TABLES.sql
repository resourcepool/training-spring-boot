create table users
(
    uid VARCHAR(255),
    constraint users_pk
        primary key (uid),
    display_name TEXT not null,
    email TEXT not null,
    profile_url TEXT not null
);

create table books
(
    id bigint auto_increment,
    constraint books_pk
        primary key (id),
    borrower_id TEXT,
    author TEXT not null,
    title TEXT not null
);
