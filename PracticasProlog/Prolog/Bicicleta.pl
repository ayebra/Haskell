parte(llanta).
parte(radios).
parte(eje).
parte(manillar).
parte(sillin).
parte(pinon).
parte(plato).
parte(pedales).
parte(cadena).

ensamble(rueda_delantera, partes([llanta, radios, eje])).
ensamble(cuadro, partes([manillar, sillin, traccion])).
ensamble(rueda_trasera, partes([llanta, radios, eje, pinon])).
ensamble(traccion, partes([eje, plato, pedales, cadena])).
ensamble(bicicleta, partes([rueda_delantera, cuadro, rueda_trasera])).

concatenar([], L, L).
concatenar([X|Y], Z, [X|U]):-concatenar(Y, Z, U).

partesde(X, [X]):-parte(X).
partesde(X, P):-ensamble(X, partes(Partes)), listapartes(Partes, P).

listapartes([], []).
listapartes([H|T], Lista):-partesde(H, PartesH),listapartes(T,PartesT),concatenar(PartesH, PartesT, Lista).
