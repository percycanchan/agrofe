/* Formatted on 15/10/2009 12:36:45 AM (QP5 v5.115.810.9015) */
DECLARE
   conn   UTL_TCP.CONNECTION;
   xmlSalida varchar2(300) :='<pedirCAE><cuit>23305957909</cuit><tipoCpr>1</tipoCpr><puntoVta>1007</puntoVta></pedirCAE>';
                              --fel_lotes
   num    NUMBER (10);
   tex    VARCHAR2 (2000);
BEGIN
   conn :=
      UTL_TCP.open_connection (remote_host => '127.0.0.1', remote_port => 6001);


   num := UTL_TCP.write_line (conn, xmlSalida);
   UTL_TCP.FLUSH (conn);
   DBMS_OUTPUT.put_line ('Write: ' || num);

   
   num := UTL_TCP.read_line(conn, tex);
   dbms_output.put_line('Lectura1: '||num||'-'|| substr(tex,1, 250));
   insert into logs (texto) values (tex);

   IF (utl_tcp.available(conn) > 0) THEN
        dbms_output.put_line('Faltan leer: '||utl_tcp.available(conn) );
       num := utl_tcp.read_line(conn, tex);
       dbms_output.put_line('Lectura2: '||num||'-'||substr(tex,1, 250));
   END IF;


   UTL_TCP.CLOSE_CONNECTION (conn);
EXCEPTION
   WHEN OTHERS
   THEN
      DBMS_OUTPUT.put_line (substr(SQLERRM, 250));
      raise_application_error (-20002, SQLERRM);
END;