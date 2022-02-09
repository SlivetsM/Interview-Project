CREATE TABLE IF NOT EXISTS product (
id bigint NOT NULL auto_increment,
product_name VARCHAR (255),
description VARCHAR (255),
stock_level INTEGER NOT NULL , PRIMARY KEY (id))