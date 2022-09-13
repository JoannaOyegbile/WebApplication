CREATE TABLE `music`(
	`id` BIGINT AUTO_INCREMENT,
	`artist_name` VARCHAR(255) NOT NULL,
	`genre` VARCHAR(255) NOT NULL,
	`release_date` VARCHAR(255) NOT NULL,
	`song_name` VARCHAR(255) NOT NULL,
	PRIMARY KEY(`id`)
);