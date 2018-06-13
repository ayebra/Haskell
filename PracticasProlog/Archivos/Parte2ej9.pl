
inc([X|X1],[Y|Y1]):-numero(X),Y is X+1,inc(X1,Y1).

