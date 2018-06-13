padre(juan,antonio).
padre(juan,luis).
padre(luis,pedro).
padre(luis,ana).

abuelo(X,Y):-padre(X,Z),padre(Z,Y).