reemplazar(String,S):- L1=[63],name(String,L4),pred(L4,L2),colocarAlInicio(L1,L2,L),name(S,L).
pred(L1,L2):-eliminar(L1,L2).
eliminar([A|L],L).
colocarAlInicio([],[]).
colocarAlInicio(L1,L2,L):-append(L1,L2,L).
