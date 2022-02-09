ALTER TABLE product ADD COLUMN retailer_id BIGINT(10);
ALTER TABLE  product ADD CONSTRAINT FK_product_retailer FOREIGN KEY (retailer_id) REFERENCES retailers(id);