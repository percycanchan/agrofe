
CREATE TABLE FE_ADM.clientes
(
  cli_CODIGO            NUMBER(8)
)
/

ALTER TABLE FE_ADM.CLIENTES ADD (
  CONSTRAINT CLIENTES_PK
 PRIMARY KEY
 (cli_CODIGO)
) 
/

insert into clientes (cli_codigo)
select rec_codigo
from factura_receptor
group by rec_codigo ;

/
commit;
/


CREATE TABLE FE_ADM.portal_usuarios
(
  usr_CODIGO            NUMBER(8),
  usr_nombre            varchar2(50),
  usr_apellido          varchar2(50),
  usr_pass              varchar2(20),
  usr_mail              varchar2(50)
)
/
insert into  portal_usuarios(usr_CODIGO, usr_nombre, usr_pass)
select rec_codigo, min( substr(REC_NOMBRE,1,50)),'111111'
from factura_receptor
group by rec_codigo ;
/
commit;
/