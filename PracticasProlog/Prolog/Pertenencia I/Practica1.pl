miembro(X, [X|_]).

miembro(X, [_|Y]):-miembro(X,Y).