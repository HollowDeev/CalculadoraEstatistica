# 📊 Calculadora Estatística Interativa em Java

Protótipo oficial desenvolvido no âmbito do **Projeto Integrado de Engenharia (PIEF II)** do curso de **Engenharia de Computação da FACAMP (Faculdades de Campinas)**.

O objetivo do software é transformar a análise estatística descritiva em uma experiência intuitiva, direta e acessível para qualquer usuário, sem a necessidade de ferramentas complexas ou planilhas poluídas.

---

## 🚀 Funcionalidades

- **Entrada Dinâmica via Teclado:** Digitação rápida de valores numéricos adicionados à lista ao pressionar a tecla `Enter`.
- **Gerenciamento Completo de Dados:** Visualização contínua da lista de números inseridos, com suporte a **edição** e **remoção** de itens.
- **Persistência da Lista pós-Cálculo:** Os dados permanecem visíveis e editáveis após a execução dos cálculos, permitindo novos recálculos imediatos sem perda do histórico.
- **Medidas de Tendência Central e Posição:**
  - **Média Aritmética ($\bar{x}$)**
  - **Mediana ($Md$):** Tratamento para número par e ímpar de observações.
  - **Moda ($Mo$):** Identificação de distribuições amodais, unimodais e multimodais.
- **Medidas de Dispersão e Variabilidade:**
  - **Desvio Padrão Amostral/Populacional ($s$)**
  - **Coeficiente de Variação ($CV$ em %)**
  - **Indicador Intuitivo de Dispersão:** Classificação automática em **"Baixa Dispersão (Dados Homogêneos)"** ($CV \le 20\%$) ou **"Alta Dispersão (Dados Heterogêneos)"** ($CV > 20\%$).
- **Seleção Modular de Métricas:** Checkboxes que permitem ao usuário escolher quais estatísticas deseja calcular.

---

## 🏗️ Arquitetura do Software

O projeto segue princípios de Programação Orientada a Objetos com separação clara de responsabilidades:

```
src/
├── CalculosEstatisticos.java   # Camada de Negócio / Métodos estatísticos
└── CalculadoraTela.java        # Camada de Apresentação / Interface gráfica (Swing)
```

1. **`CalculosEstatisticos.java`:** Classe responsável exclusivamente pelos algoritmos matemáticos e regras de negócio estatísticas (`calcularMedia`, `calcularMediana`, `calcularModa`, `calcularDesvioPadrao`, `calcularCoeficienteVariacao` e `verificarDispersao`).
2. **`CalculadoraTela.java`:** Classe responsável pela interface gráfica (GUI com Java Swing), captura de eventos do teclado (`KeyEvent.VK_ENTER`), manipulação do `DefaultListModel` e renderização dos resultados.

---

## 🛠️ Como Compilar e Executar

### Pré-requisitos
- **Java Development Kit (JDK)** versão 8 ou superior instalado.
- Sem necessidade de bibliotecas externas (utiliza apenas a biblioteca padrão `javax.swing` e `java.awt`).

### Passos no Terminal

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/HollowDeev/CalculadoraEstatistica.git
   cd CalculadoraEstatistica
   ```

2. **Compile as classes:**
   ```bash
   javac src/CalculosEstatisticos.java src/CalculadoraTela.java
   ```

3. **Execute a aplicação:**
   ```bash
   java -cp src CalculadoraTela
   ```

---

## 👥 Autores

Desenvolvido pelos alunos de Engenharia de Computação (FACAMP - 2026):
- **Thauã** (Product Owner)
- **Tommy** (ScrumMaster)
- **Nathália & Equipe** (Development Team)

Orientadores / Professores:
- Prof. Pedro Grosso (Cliente / Engenharia de Requisitos)
- Prof. Willian Augustonelli (Laboratório de Programação)
- Prof. Sérgio Yoshioka (Gestão de Projetos)
