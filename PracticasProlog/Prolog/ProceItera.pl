progenitor(juan,antonio).
progenitor(juan,luis).

factorial(N,F):-factorial(0,N,1,F).
factorial(I,N,T,F):-I<N,I1 is I+1, T1 is T*11, factorial(I1,N,T1,F).
factorial(N,N,F,F).