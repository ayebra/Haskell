pred2(L,N):-findall([Y],member(Y,L),N).
pred3(X,Y):-findall(pred(Y,Y),member(Y,X),Y).
pred4(L,Y):-findall([elemento,Y],member(Y,L),Y).
