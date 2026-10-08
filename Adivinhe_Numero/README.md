# Adivinhe o Número

Este é um jogo simples de adivinhação feito em Java como parte do meu aprendizado da linguagem. Estou começando a aprender Java e migrando do JavaScript, então este projeto também é uma forma de praticar conceitos novos e comparar as duas linguagens.

## Como funciona

O jogo escolhe um número aleatório entre 1 e 50. O jogador tem até 7 tentativas para adivinhar. A cada palpite, recebe uma dica para tentar um número maior ou menor. Ao final, pode escolher se quer jogar novamente.

## Como executar

É necessário ter o JDK instalado. No terminal, a partir da pasta principal do projeto, execute:

```powershell
New-Item -ItemType Directory -Force out
javac -encoding UTF-8 -d out src\AdivnheNumero.java
java -cp out AdivnheNumero
```

## Objetivo de aprendizado

O projeto pratica entrada de dados com `Scanner`, geração de números aleatórios, estruturas de repetição e condicionais, métodos e validação de entrada.
