CREATE TABLE IF NOT EXISTS Post(
    id int auto_increment primary key,
    title varchar(255) not null,
    content text not null
);


--INSERT INTO POST(title,content) VALUES ('title','content')