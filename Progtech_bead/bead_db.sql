CREATE TABLE IF NOT EXISTS `progtech_db`.`cars` (
  `cars_id` INT NOT NULL AUTO_INCREMENT,
  `manufacturer` VARCHAR(100) NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `price_per_day` INT NOT NULL,
  PRIMARY KEY (`cars_id`));
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `progtech_db`.`users` (
  `users_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `address` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`users_id`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `progtech_db`.`payment` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `method` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`payment_id`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `progtech_db`.`rental` (
  `rental_id` INT NOT NULL AUTO_INCREMENT,
  `rented_from` DATE NOT NULL,
  `rented_to` DATE NOT NULL,
  `cars_cars_id` INT NOT NULL,
  `users_users_id` INT NOT NULL,
  `payment_payment_id` INT NOT NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`rental_id`),
  INDEX `fk_rental_cars_idx` (`cars_cars_id` ASC) VISIBLE,
  INDEX `fk_rental_users1_idx` (`users_users_id` ASC) VISIBLE,
  INDEX `fk_rental_payment1_idx` (`payment_payment_id` ASC) VISIBLE,
  CONSTRAINT `fk_rental_cars`
    FOREIGN KEY (`cars_cars_id`)
    REFERENCES `progtech_db`.`cars` (`cars_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_users1`
    FOREIGN KEY (`users_users_id`)
    REFERENCES `progtech_db`.`users` (`users_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_payment1`
    FOREIGN KEY (`payment_payment_id`)
    REFERENCES `progtech_db`.`payment` (`payment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

INSERT INTO cars(  manufacturer,     model,     price_per_day ) VALUES(  'test',     'test',     8000 );

INSERT INTO cars(  manufacturer,     model,     price_per_day ) VALUES (  'Opel',     'Astra',     6000 );

INSERT INTO users (  username,     password,     email,     first_name,     last_name,     address ) VALUES(  'balint',     'password',     'palbalint22@gmail.com',     'Pál',     'Bálint',     'Karancslapujtő Május 1 Út 19' );

insert into payment(  method ) values(  'credit card' );

insert into payment(  method ) values(  'cash' );



