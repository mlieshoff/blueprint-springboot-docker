CREATE TABLE IF NOT EXISTS `example` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `value` varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into `example` (`id`, `value`) values (1, 'example1');
insert into `example` (`id`, `value`) values (2, 'example2');