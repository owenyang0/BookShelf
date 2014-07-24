DROP DATABASE IF EXISTS BOOKSHELF;
CREATE DATABASE BOOKSHELF;
USE BOOKSHELF;

--CREATE TABLE BOOK (
--	ISBN INT UNSIGNED NOT NULL,
--	NAME VARCHAR (100) NOT NULL,
--	PRICE DOUBLE NOT NULL,
--	AUTHOR VARCHAR (100) NOT NULL,
--	PRIMARY KEY(ISBN)
--);

CREATE TABLE BOOK (
    ISBN VARCHAR (24) NOT NULL,
    NAME VARCHAR (100) NOT NULL,
    PRICE DOUBLE NOT NULL,
    AUTHOR VARCHAR (100) NOT NULL,
    PRIMARY KEY(ISBN)
);
