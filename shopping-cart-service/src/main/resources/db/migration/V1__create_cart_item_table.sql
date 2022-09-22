-- 'ossp' is not loaded by default, hence the extension must be explicitly enabled in case it does not exist
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS CART_ITEM (
  CART_ITEM_ID SERIAL PRIMARY KEY,
  ID UUID DEFAULT uuid_generate_v4() NOT NULL,
  USER_ID UUID NOT NULL,
  PRODUCT_ID UUID NOT NULL,
  DISCOUNT NUMERIC(4,2) NULL DEFAULT 0,
  QUANTITY INTEGER NOT NULL DEFAULT 0,
  DAT_INS TIMESTAMP NOT NULL,
  DAT_UPD TIMESTAMP,
  USR_INS VARCHAR(256) NOT NULL,
  USR_UPD VARCHAR(256),
  STAT CHAR(1) NOT NULL CHECK (STAT in ('A', 'I', 'D'))
);

COMMENT ON COLUMN CART_ITEM.CART_ITEM_ID IS 'Auto-generated internal id (i.e. primary key)';
COMMENT ON COLUMN CART_ITEM.ID IS 'Cart item id used as an external identifier';
COMMENT ON COLUMN CART_ITEM.USER_ID IS 'User/owner of the cart item';
COMMENT ON COLUMN CART_ITEM.PRODUCT_ID IS 'Product id';
COMMENT ON COLUMN CART_ITEM.DISCOUNT IS 'Product discount';
COMMENT ON COLUMN CART_ITEM.QUANTITY IS 'Product quantity';
COMMENT ON COLUMN CART_ITEM.DAT_INS IS 'Creation date of the record';
COMMENT ON COLUMN CART_ITEM.DAT_UPD IS 'Modification date of the record';
COMMENT ON COLUMN CART_ITEM.USR_INS IS 'Identity of the user that created the record';
COMMENT ON COLUMN CART_ITEM.USR_UPD IS 'Identity of the user that modified the record';
COMMENT ON COLUMN CART_ITEM.STAT IS 'Status of the record A = active, I = inactive, D = deleted';

CREATE INDEX CART_IDX1 ON CART_ITEM (ID);
CREATE UNIQUE INDEX CART_UIDX1 ON CART_ITEM (USER_ID, PRODUCT_ID);