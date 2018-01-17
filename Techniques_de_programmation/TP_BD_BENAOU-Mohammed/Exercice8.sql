ALTER TABLE clients ALTER COLUMN cp char(5) not null;
ALTER TABLE clients ADD tel char(14) not null check (tel like ('__-__-__-__-__-__-__'));
ALTER TABLE clients ADD ville char(25) not null;