### Relógio Físico

Em sistemas distribuídos refere-se a um relógio real, como o de um computador, 
que mede o tempo em segundos, minutos, etc. 
Ele é sincronizado com um padrão de tempo global, como o UTC (Tempo Universal Coordenado), geralmente através de protocolos como o NTP (Network Time Protocol).
Em um sistema distribuído, é quase impossível que todos os computadores tenham seus relógios físicos perfeitamente sincronizados. 
Pequenas diferenças, chamadas de *desvio de relógio*, podem causar inconsistências na ordem dos eventos.

### Relógio Lógico

É uma solução para o problema do relógio físico. 
Em vez de medir o tempo real, ele estabelece uma ordem de eventos com base na causalidade, ou seja, se um evento A causa um evento B,
A deve ocorrer antes de B. 
Os dois conceitos principais são:

**Relógio de Lamport: Utiliza um contador para dar um carimbo de tempo (*timestamp*) a cada evento. 
As regras são:
    1.  Ao ocorrer um evento em um processo, o contador é incrementado.
    2.  Ao enviar uma mensagem, o contador é incrementado e o valor atual é incluído na mensagem.
    3.  Ao receber uma mensagem, o relógio do processo receptor é atualizado para o maior valor entre seu próprio contador e o contador da mensagem, e então é incrementado.
    Isso garante que se um evento A precede B, então o carimbo de tempo de A é menor que o de B. 
    No entanto, o contrário não é necessariamente verdade (se o carimbo de tempo de A é menor que o de B, não significa que A causou B).

**Relógio Vetorial: Aprimora o relógio de Lamport ao usar um vetor de contadores para cada processo. 
Cada elemento do vetor representa o conhecimento do processo sobre o estado de outros processos. 
Isso permite determinar não apenas a ordem, mas também a relação de causalidade entre os eventos. 
É mais complexo, mas oferece uma visão mais precisa da ordem dos eventos.

### Exclusão Mútua

É um conceito fundamental na programação concorrente e sistemas distribuídos. 
Ele garante que, em qualquer momento, apenas uma única thread (ou processo) possa acessar um **recurso compartilhado** (como uma variável, arquivo, ou banco de dados)
que não pode ser acessado por múltiplas threads simultaneamente.
A parte do código que acessa o recurso compartilhado é chamada de **seção crítica**.

O objetivo é vitar condições de corrida (*race conditions*), onde o resultado de uma operação depende da ordem de execução de múltiplas threads, 
o que pode levar a dados corrompidos ou inconsistentes.
As principais abordagens são:
    locks: Uma thread adquire um "cadeado" (lock) antes de entrar na seção crítica e o libera ao sair. Se outra thread tentar entrar enquanto o cadeado estiver ocupado,
ela será bloqueada.
    Semáforos: Mecanismos mais gerais que podem ser usados para exclusão mútua e também para sincronizar o acesso a um número limitado de recursos.

### Eleição em Threads

Em sistemas distribuídos é o processo de escolher um único processo (ou thread) para ser o **coordenador**, líder ou mestre.
Esse líder é responsável por tomar decisões ou gerenciar o acesso a um recurso. A eleição é necessária quando o coordenador atual falha ou quando o sistema é inicializado.

## Race Condition
É um problema que acontece na programação concorrente, quando duas ou mais threads (ou processos) tentam acessar e modificar o mesmo recurso compartilhado ao mesmo tempo.
O resultado final do programa depende da ordem exata em que essas threads executam suas operações, o que é imprevisível.

## Seções críticas ou Critical Sections

São partes do código de um programa onde recursos compartilhados são acessados ou modificados.
Esses recursos podem ser variáveis, estruturas de dados, arquivos, ou qualquer outro dado que possa ser usado por mais de uma thread ou processo simultaneamente.
O grande problema surge quando múltiplas threads tentam entrar na mesma seção crítica ao mesmo tempo. 
Se a seção crítica envolve a modificação de dados, isso pode levar a uma condição de corrida (race condition)

## Recurso Compartilhado 

É qualquer dado, variável, ou hardware que pode ser acessado por múltiplas threads ou processos em um sistema de computação.
O nome já sugere sua principal característica: ele não pertence exclusivamente a uma única thread, mas é "compartilhado" entre elas.
