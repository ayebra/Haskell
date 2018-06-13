sucesor(1,2).
sucesor(2,3).
sucesor(3,4).
sucesor(4,5).
sucesor(5,6).
sucesor(6,7).

suma(1,X,R):-sucesor(X,R).
suma(N,X,R):-sucesor(M,N),suma(M,X,R1),sucesor(R1,R).