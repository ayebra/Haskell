salida(Ultimo,Ultimo):-write(Ultimo),write(' El cuadrado del numero es: '),
    A is Ultimo * Ultimo, write(A), nl.
salida(Primero,Ultimo):-Primero=\=Ultimo,write(Primero),write(' El cuadrado del numero es: '),
    B is Primero * Primero, write(B),nl,N is Primero+1, salida(N,Ultimo).
