leer_y_probar(N,par):-N mod 2 =:=0,!.
leer_y_probar(N,impar).
ejecutar:-repeat,write('Ingresa un numero: '),read(N),leer_y_probar(N,Tipo),write(N),
   write(' '), write(' es '),write(' '),write(Tipo),nl,N=:=100.
