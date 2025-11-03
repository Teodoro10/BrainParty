# BrainParty - Versão Simplificada em Java

Uma versão **muito mais simples e enxuta** do jogo da memória BrainParty, desenvolvida em Java puro com apenas **3 classes** e **~350 linhas de código total**.

## 📊 Comparação com a Versão Original

| Aspecto | Original | Simplificada |
|---------|----------|--------------|
| **Número de Classes** | 4 | 3 |
| **Linhas de Código** | ~500 | ~350 |
| **Dependências** | Maven + JavaFX | Nenhuma (Java puro) |
| **Complexidade** | Alta | Baixa |
| **Fácil de Entender** | Não | Sim ✅ |
| **Tamanho do JAR** | ~100KB | ~10KB |

## 🎮 O que é BrainParty?

BrainParty é um jogo da memória clássico onde você precisa encontrar pares de cartas. Nesta versão simplificada:

- **16 cartas** dispostas em um grid 4x4
- **8 pares** de palavras em inglês e português
- **Contador de movimentos** para rastrear sua performance
- **Cronômetro** para medir o tempo gasto
- **Interface simples** com Swing

## 🚀 Como Executar

### Pré-requisitos

Você precisa ter o **Java 11 ou superior** instalado. Verifique com:

```bash
java -version
```

Se não tiver Java, faça o download em: https://www.oracle.com/java/technologies/downloads/

### Opção 1: Usando o Script (Linux/macOS)

```bash
chmod +x run.sh
./run.sh
```

### Opção 2: Usando o Script (Windows)

Simplesmente clique duas vezes em `run.bat` ou execute no terminal:

```cmd
run.bat
```

### Opção 3: Compilar e Executar Manualmente

```bash
# Criar diretório de saída
mkdir -p bin

# Compilar
javac -d bin src/com/brainparty/*.java

# Executar
java -cp bin com.brainparty.GameGUI
```

### Opção 4: Usando Maven (se instalado)

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.brainparty.GameGUI"
```

## 📁 Estrutura do Projeto

```
BrainParty_Java_Simples/
├── src/
│   └── com/brainparty/
│       ├── Card.java          # Classe da carta (simples)
│       ├── Game.java          # Lógica do jogo
│       └── GameGUI.java       # Interface gráfica
├── bin/                       # Classes compiladas (gerado)
├── pom.xml                    # Configuração Maven
├── run.sh                     # Script para Linux/macOS
├── run.bat                    # Script para Windows
└── README.md                  # Este arquivo
```

## 🎯 Como Jogar

1. **Inicie o jogo** usando um dos métodos acima
2. **Clique em uma carta** para virar
3. **Clique em outra carta** para tentar encontrar o par
4. **Se as palavras forem iguais**, elas permanecem viradas (verde)
5. **Se forem diferentes**, viram novamente (azul)
6. **Continue até encontrar todos os 8 pares**
7. **Veja sua pontuação** (movimentos e tempo)

## 📝 Código Simplificado

### Card.java (~45 linhas)
Representa uma única carta com palavra em inglês e tradução em português.

```java
public class Card {
    private String word;
    private String translation;
    private boolean flipped;
    private boolean matched;
    
    // Getters, setters e métodos simples
}
```

### Game.java (~100 linhas)
Gerencia a lógica do jogo: embaralhamento, verificação de pares, pontuação.

```java
public class Game {
    private List<Card> cards;
    private int moves;
    
    public boolean checkMatch(int index1, int index2) {
        // Verifica se duas cartas formam um par
    }
}
```

### GameGUI.java (~200 linhas)
Interface gráfica com Swing: botões de cartas, estatísticas, controles.

```java
public class GameGUI extends JFrame {
    private Game game;
    private JButton[] cardButtons;
    
    private void cardClicked(int index) {
        // Lógica de clique nas cartas
    }
}
```

## 🎨 Características

✅ **Interface Simples**: Fácil de usar e entender
✅ **Código Limpo**: Bem organizado e comentado
✅ **Sem Dependências Externas**: Usa apenas Java puro
✅ **Rápido**: Compila em segundos
✅ **Leve**: Arquivo JAR menor que 10KB
✅ **Multiplataforma**: Funciona em Windows, macOS e Linux

## 🔧 Personalizações

Você pode facilmente modificar o jogo:

### Adicionar Mais Pares de Palavras

Edite `Game.java` e adicione mais pares no array `wordPairs`:

```java
String[][] wordPairs = {
    {"Cat", "Gato"},
    {"Dog", "Cachorro"},
    // ... adicione mais pares aqui
};
```

### Mudar Cores

Edite `GameGUI.java` e altere os valores de `Color`:

```java
btn.setBackground(new Color(100, 149, 237)); // Azul
btn.setBackground(new Color(144, 238, 144)); // Verde
```

### Aumentar Dificuldade

Aumente o número de pares ou reduza o tempo de visualização:

```java
Timer timer = new Timer(500, e -> { // Reduzir de 800 para 500ms
    // ...
});
```

## 📚 Aprendizado

Este projeto é perfeito para:

- **Iniciantes em Java**: Código simples e bem estruturado
- **Aprender Swing**: Interface gráfica básica
- **Entender Lógica de Jogos**: Mecânicas simples mas efetivas
- **Praticar OOP**: Classes bem definidas com responsabilidades claras

## 🐛 Troubleshooting

### "javac: command not found"
Java não está instalado ou não está no PATH. Instale o JDK.

### "Exception in thread 'main' java.lang.ClassNotFoundException"
Certifique-se de que compilou com `javac -d bin src/com/brainparty/*.java`

### A janela não aparece
Se estiver em um servidor sem display, use a versão web em vez disso.

## 📦 Criar um JAR Executável

```bash
# Compilar
javac -d bin src/com/brainparty/*.java

# Criar JAR
jar cfe BrainParty.jar com.brainparty.GameGUI -C bin .

# Executar
java -jar BrainParty.jar
```

## 🎓 Próximos Passos

Ideias para expandir o projeto:

1. **Adicionar Som**: Efeitos sonoros ao encontrar pares
2. **Ranking**: Salvar e mostrar melhores pontuações
3. **Dificuldades**: Fácil (6 pares), Médio (8 pares), Difícil (12 pares)
4. **Multiplayer**: Competição entre dois jogadores
5. **Temas**: Diferentes temas de cores
6. **Idiomas**: Suporte a múltiplos idiomas

## 📄 Licença

Este projeto é de código aberto e pode ser usado livremente para fins educacionais.

---

**Desenvolvido com ❤️ em Java Puro**

Versão: 1.0-SIMPLE | 2025-10-20

