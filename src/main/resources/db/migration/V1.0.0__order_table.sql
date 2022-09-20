CREATE TABLE IF NOT EXISTS `order`(
    `id` varchar(120) NOT NULL,
    `store_name` varchar(120) NOT NULL,
    `item_name` varchar(120) NOT NULL,
    `quantity` int(20) NOT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE =utf8mb4_unicode_ci;