# course_app
challenge application

Установить MySQL

прописать для доступа в БД:
src/main/resources/application.properties

создание таблицы:

CREATE SCHEMA `course` ;
CREATE TABLE `course`.`students` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` 
VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `result` FLOAT NULL DEFAULT 0,
  `check` TINYINT(1) NULL,
  `question` FLOAT NULL DEFAULT 0,
  `answer` FLOAT NULL DEFAULT 0,
PRIMARY KEY (`id`), `subgroup` TINYINT UNSIGNED NULL);
