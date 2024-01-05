-- Changeset gml:0002
-- Contexts:
-- Precondition:

INSERT INTO authorities (username, authority)
            SELECT username, 'ROLE_USER'
            FROM chatters_entity
            WHERE NOT EXISTS (
                SELECT 1
                FROM authorities
                WHERE authorities.username = chatters_entity.username
                  AND authorities.authority = 'ROLE_USER'
            );
--rollback: DELETE FROM authorities WHERE authority = 'ROLE_USER';