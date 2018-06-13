cambiar(tu, yo).
cambiar(eres, [no, soy]).
cambiar(hablas, [no_, hablo]).
cambiar(frances, aleman).
cambiar(X,X).

alterar([], []).
alterar([H|T], [X|Y]):- cambiar(H,X), alterar(T,Y).