libros_por_devolver(c_perez,libro10089).
libros_por_devolver(a_ramos,libro29907).

cliente(a_ramos).
cliente(c_perez).
cliente(p_gonzalez).

servicio_basico(referencia).
servicio_basico(consulta).

servicio_adicional(prestamo).
servicio_adicional(pres_inter_biblio).

servicio_general(X):-servicio_basico(X).
servicio_general(X):-servicio_adicional(X).

servicio(Pers,Serv):-
cliente(Pers),
libros_por_devolver(Pers,libro),
!,
servicio_basico(Serv).
servicio(Pers,Serv):-
cliente(Pers),
servicio_general(Serv).