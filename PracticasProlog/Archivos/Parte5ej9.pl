colocarAlFinal(A,[],[A]).
colocarAlFinal(A,[B|C],[B|D]):-colocarAlFinal(A,C,D).
