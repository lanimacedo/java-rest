# Projeto de Testes de API

Este é um projeto de testes automatizados de API utilizando **Java**, **REST Assured**, **JUnit 5** e **Allure** para geração de relatórios. A API usada como base é o [JSONPlaceholder](https://jsonplaceholder.typicode.com), uma API pública para simulação de testes.

---

## 📁 Estrutura do Projeto


---

## 🚀 Tecnologias Utilizadas

- Java 17
- REST Assured 5.3.0
- JUnit 5.10.0
- Allure 2.24.0
- Maven

---

## ⚙️ Pré-requisitos

- Java 17 instalado
- Maven instalado
- Allure instalado  
  ➤ macOS: `brew install allure`  
  ➤ Windows: via [Chocolatey](https://chocolatey.org/packages/allure)

---

## 🔧 Configuração

As configurações da API estão centralizadas no arquivo `resources/config.properties`:

```properties
base.uri=https://jsonplaceholder.typicode.com
base.path=/posts
```

---

## 🧪 Executando os Testes

### ✅ Executar todos os testes

```bash
mvn clean test
```

## Gerar relatorio Allure

```
allure serve target/allure-results
```

