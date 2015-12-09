Update Jogo j
  set j.vencedor = 'A'
  where j.resultadoA > j.resultadoB;
  
Update Jogo j
  set j.vencedor = 'B'
  where j.resultadoB > j.resultadoA;
  
Update Jogo j
  set j.vencedor = 'E'
  where j.resultadoA = j.resultadoB;  
  

update Evento e 
  set e.imgName = 'gol_16x16.png' 
  where id = 1;
  
update Evento e set e.imgName = 'cartao-amarelo_16.png' where id = 2;

update Evento e set e.imgName = 'cartao-vermelho_16.png' where id = 3;