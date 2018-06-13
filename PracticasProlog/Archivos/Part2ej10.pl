trim([ A | L ] , L1 ):- A =<32 ,trim(L ,L1 ),!.
trim([ A | L ],[ A | L ]):- A>32.
trim2(L , L1 ):-reverse(L , Lrev ), trim( Lrev , L2 ) , reverse( L2 , L1 ).
trim3(L , L1 ):- trim(L , L2 ) , trim2( L2 , L1 ).
eliminar_final(String , Snuevo ):-name(String , L ) , trim3(L , L1 ) , name( Snuevo,L1 ).
