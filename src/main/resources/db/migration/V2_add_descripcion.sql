ALTER TABLE productos ADD COLUMN descripcion VARCHAR(255);
UPDATE productos SET descripcion = 'sin descripción' WHERE descripcion IS NULL;
ALTER TABLE productos ALTER COLUMN descripcion SET NOT NULL;