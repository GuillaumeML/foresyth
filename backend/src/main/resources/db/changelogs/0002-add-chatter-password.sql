-- Changeset gml:0002
-- Contexts:
-- Precondition:
ALTER TABLE public.chatter_entity ADD password VARCHAR(255) NOT NULL;

-- rollback ALTER TABLE chatter_entity DROP COLUMN password