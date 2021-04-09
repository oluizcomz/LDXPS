drop database LDXPS;
create database LDXPS;
use LDXPS;
create table VENDEDORES(
CDVEND  varchar(36) not null,
DSNOME varchar(50) not null,
CDTAB integer not null,
DTNASC date,
primary key (CDVEND)
);
create table CLIENTES(
CDCL varchar(36) not null,
DSNOME varchar(50) not null,
IDTIPO enum('PF','PJ') default 'PF',
CDVEND varchar(36) not null,
DSLIM decimal(15,2),
primary key (CDCL),
FOREIGN KEY (CDVEND) REFERENCES VENDEDORES(CDVEND)
);
INSERT into VENDEDORES(CDVEND,DSNOME,CDTAB,DTNASC) VALUES ('COD1','Luiz Moura','123','1998/09/06');
UPDATE VENDEDORES SET DSNOME = 'AUTERADO AI ', CDTAB = '321', DTNASC = '1997/11/30' WHERE CDVEND = 'cod2';
SELECT * FROM VENDEDORES;