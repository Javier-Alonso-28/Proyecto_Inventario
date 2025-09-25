ALTER TABLE productos ADD COLUMN categoria_id BIGINT;
ALTER TABLE productos ADD COLUMN proveedor_id BIGINT;

UPDATE productos SET categoria_id = 1 WHERE categoria_id IS NULL;
UPDATE productos SET proveedor_id = 1 WHERE proveedor_id IS NULL;

ALTER TABLE productos ALTER COLUMN categoria_id SET NOT NULL;
ALTER TABLE productos ALTER COLUMN proveedor_id SET NOT NULL;

ALTER TABLE productos
    ADD CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categorias(id);

ALTER TABLE productos
    ADD CONSTRAINT fk_proveedor FOREIGN KEY (proveedor_id) REFERENCES proveedores(id);
