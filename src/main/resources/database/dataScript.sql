USE `testdb`;

INSERT INTO `producers` (`FIRST_NAME`, `LAST_NAME`, `BIRTH_DATE`, `COUNTRY`, `GENDER`) VALUES 
('Энтони', 'Руссо', '1970-02-03', 'США', 'мужчина'),
('Гай', 'Ричи', '1968-09-10', 'Англия', 'мужчина'),
('Ник', 'Маршалл', '1970-05-25', 'Англия', 'мужчина'),
('Андрей', 'Волгин', '1981-12-22', 'Россия', 'мужчина'),
('Майкл', 'Догерти', '1974-10-28', 'США', 'мужчина'),
('Мартин', 'Скорсезе', '1942-11-17', 'США', 'мужчина'),
('Луи', 'Летерье', '1973-06-17', 'Франция', 'мужчина'),
('Райан', 'Джонсон', '1973-12-17', 'США', 'мужчина'),
('Марк', 'Уэбб', '1974-08-31', 'США', 'мужчина'),
('Рон', 'Ховард', '1954-04-01', 'США', 'мужчина'),
('Тайка', 'Вайтити', '1975-08-16', 'Новая Зеландия', 'мужчина');

INSERT INTO `actors` (`FIRST_NAME`, `LAST_NAME`, `BIRTH_DATE`, `COUNTRY`, `GENDER`) VALUES 
('Марк', 'Руффало', '1967-11-22', 'США', 'мужчина'),
('Крис', 'Эванс', '1981-06-13', 'США', 'мужчина'),
('Скарлет', 'Йохансон', '1984-11-22', 'США', 'женщина'),
('Крис', 'Хемсворт', '1983-08-11', 'Австралия', 'мужчина'),
('Джереми', 'Реннер', '1971-01-07', 'США', 'мужчина'),
('Мена', 'Массуд', '1991-09-17', 'Египет', 'мужчина'),
('Наоми', 'Скотт', '1993-05-06', 'Англия', 'женщина'),
('Марван', 'Кензари', '1983-01-16', 'Нидерланды', 'мужчина'),
('Навид', 'Негабан', '1968-06-02', 'Иран', 'мужчина'),
('Дэвид', 'Харбор', '1975-04-10', 'США', 'мужчина'),
('Мила', 'Йовович', '1975-12-17', 'Украина', 'женщина'),
('Йэн', 'Макшейн', '1942-09-29', 'Англия', 'мужчина'),
('Антон', 'Пампушный', '1982-05-05', 'Казахстан', 'мужчина'),
('Милена', 'Радулович', '1995-01-29', 'Сербия', 'женщина'),
('Милош', 'Бикович', '1988-01-13', 'Сербия', 'мужчина'),
('Кайл', 'Чандлер', '1965-09-17', 'США', 'мужчина'),
('Вера', 'Фармига', '1973-08-06', 'США', 'женщина'),
('Милли', 'Браун', '2004-02-19', 'Испания', 'женщина'),
('Кэн', 'Ватанабэ', '1959-10-21', 'Япония', 'мужчина'),
('Чжан', 'Цзыи', '1979-02-09', 'Китай', 'женщина'),
('Салли', 'Хокинс', '1976-04-27', 'Англия', 'женщина');

INSERT INTO `films` (`NAME`, `RELEASE`, `COUNTRY`, `DURATION_MINUTES`, `MONEY_FEES`, `GENRE`, `PRODUCER_ID`) VALUES 
('Мстители: Финал', '2019-04-22', 'США', 181, 2797800564, 'фантастика', 1),
('Алладин', '2019-05-08', 'США', 128, 1050693953, 'приключения', 2),
('Хеллбой', '2019-04-09', 'США', 120, 44664690, 'боевик', 3),
('Балканский рубеж', '2019-04-21', 'Россия', 151, 5849400, 'боевик', 4),
('Годзилла 2: Король Монстров', '2019-05-30', 'Япония', 132, 385900138, 'фантастика', 5),
('Остров проклятых', '2010-02-13', 'США', 138, 294804195, 'триллер', 6),
('Иллюзия обмана', '2013-05-21', 'США', 115, 351723989, 'триллер', 7),
('Достать ножи', '2019-09-07', 'США', 131, 283394368, 'детектив', 8),
('Одаренная', '2017-04-07', 'США', 101, 43046590, 'драма', 9),
('Гонка', '2013-09-02', 'Англия', 123, 90247624, 'спорт', 10),
('Тор: Рагнарёк', '2017-10-10', 'США', 130, 853977126, 'фантастика', 11),
('Отступники', '2006-09-26', 'США', 151, 291465034, 'триллер', 6),
('Казино', '1995-04-03', 'США', 171, 116112375, 'драма', 6),
('Дэнни цепной пес', '2005-01-10', 'Франция', 103, 50871113, 'боевик', 7),
('Перевозчик', '2002-10-02', 'Франция', 92, 43928932, 'боевик', 7);

INSERT INTO `actors_films` (`ACTOR_ID`, `FILM_ID`) VALUES 
(1, 1),
(1, 6),
(1, 7),
(2, 1),
(2, 8),
(2, 9),
(3, 1),
(4, 1),
(4, 10),
(4, 11),
(5, 1),
(6, 2),
(7, 2),
(8, 2),
(9, 2),
(10, 3),
(11, 3),
(12, 3),
(13, 4),
(14, 4),
(15, 4),
(16, 5),
(17, 5),
(18, 5),
(19, 5),
(20, 5),
(21, 5);
