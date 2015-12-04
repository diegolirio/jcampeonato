Update Jogo j
  set j.vencedor = 'A'
  where j.resultadoA > j.resultadoB;
  
Update Jogo j
  set j.vencedor = 'B'
  where j.resultadoB > j.resultadoA;
  
Update Jogo j
  set j.vencedor = 'E'
  where j.resultadoA = j.resultadoB;  