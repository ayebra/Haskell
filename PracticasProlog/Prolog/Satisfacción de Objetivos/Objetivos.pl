padre(juan, antonio).
padre(juan, luis).
padre(luis, pedro).

abuelo(X,Y):-padre(X,Z),padre(Z,Y).


