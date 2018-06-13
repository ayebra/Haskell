progenitor(juan,antonio).
progenitor(juan,luis).

prodecesor(X,Z):-progenitor(X,Z).
predecesor(X,Z):-progenitor(X,Y),prodecesor(Y, Z).
