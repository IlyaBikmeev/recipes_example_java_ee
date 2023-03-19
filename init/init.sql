CREATE TABLE recipe(
    id int primary key auto_increment,
    author varchar(50) not null,
    title varchar(50) not null,
    description varchar(50) not null
);

INSERT INTO recipe(author, title, description)
VALUES
('i@bikmeev.ru', 'Драники', 'Для приготовления драников нам понадобится...'),
('i@bikmeev.ru', 'Драники', 'Для приготовления драников нам понадобится...'),
('i@bikmeev.ru', 'Драники', 'Для приготовления драников нам понадобится...'),
('i@bikmeev.ru', 'Драники', 'Для приготовления драников нам понадобится...')