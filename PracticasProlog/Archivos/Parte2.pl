ejecutar:-get0(X),proceso(X).
proceso(10).
proceso(63).
proceso(X):-X=\=10,X=\=63,put(X),ejecutar.
