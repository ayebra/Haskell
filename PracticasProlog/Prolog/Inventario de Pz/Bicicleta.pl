parte(cadena).
parte(eje).
parte(plato).
parte(pedales).
parte(llanta).
parte(radios).
parte(eje).
parte(manillar).
parte(sillin).
parte(traccion).
parte(piñones).


ensamblaje(rueda_delantera, partes([llantas, radios, eje])).
ensamblaje(cuadro, partes([manillar, sillin, traccion])).
ensamblaje(rueda_trasera, partes([llanta, radios, eje, pinon])).
ensamblaje(traccion, partes([eje, plato, pedales, cadena])).
ensamblaje(bicibleta, partes([rueda_delantera, cuadro, rueda_tracera])).

concatenar([], L, L).
concatenar([X|Y], Z, [X|U]) :- concatenar(Y, Z, U).

partesde(X, [X]) :-parte(X).
partesde(X, P) :-ensamble(X, partes(Partes)), listapartes(Partes, P).

listaspartes([], []).
listapartes([H|T], Lista) :-partesde(H, PartesH), listapartes(T, PartesT), concatenar(PartesH, PartesT, Lista).