/**
 * Author:  fqlh0717
 * Created: 6 sept. 2018
 */
INSERT INTO roles 
    (id_role, date_creation, is_default, role) 
SELECT 1, CURRENT_DATE, true, 'ROLE_USER'
WHERE
    NOT EXISTS (
        SELECT role FROM roles WHERE role = 'ROLE_USER'
    );

INSERT INTO roles 
    (id_role, date_creation, is_default, role) 
SELECT 2, CURRENT_DATE, false, 'ROLE_ADMIN'
WHERE
    NOT EXISTS (
        SELECT role FROM roles WHERE role = 'ROLE_ADMIN'
    );

INSERT INTO roles 
    (id_role, date_creation, is_default, role) 
SELECT 3, CURRENT_DATE, false, 'ROLE_DEV'
WHERE
    NOT EXISTS (
        SELECT role FROM roles WHERE role = 'ROLE_DEV'
    );