ALTER TABLE clients ADD cp char(5);
ALTER TABLE clients ADD tel char(14)check (tel like ('__-__-__-__-__-__-__'));
ALTER TABLE clients ADD ville char(25);