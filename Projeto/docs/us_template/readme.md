# US 3004

*Este é um modelo de exemplo*

## 1. Contexto

*Explain the context for this task. It is the first time the task is assigned to be developed or this tasks was incomplete in a previous sprint and is to be completed in this sprint? Are we fixing some bug?*

## 2. Requisitos

*In this section you should present the functionality that is being developed, how do you understand it, as well as possible correlations to other requirements (i.e., dependencies).*

*Example*

**US G002** As {Ator} I Want...

- G002.1. Blá Blá Blá ...

- G002.2. Blá Blá Blá ...

*Regarding this requirement we understand that it relates to...*

### 2.1. Complementos encontrados
*User stories que complementam a funcionalidade desta.*

### 2.2. Dependências encontradas
*User stories das quais esta depende.*

### 2.3. Critérios de aceitação

## 3. Análise

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

### 3.1. Respostas do cliente

>**Questão:** ".."
> 
>**Resposta:** "..."

### 3.2. Diagrama de Sequência do Sistema

### 3.3. Classes de Domínio

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Diagrama de Sequência

### 4.2. Diagrama de Classes

![a class diagram](class-diagram-01.svg "A Class Diagram")

### 4.3. Padrões Aplicados

### 4.4. Testes

**Teste 1:** *Verifies that it is not possible to create an instance of the Example class with null values.*

```
@Test(expected = IllegalArgumentException.class)
public void ensureNullIsNotAllowed() {
	Example instance = new Example(null, null);
}
````

## 5. Implementação

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 5.1. Arquitetura em Camadas
### Domínio

### Aplicação

### Repositório

### Apresentação

## 5.2. Commits Relevantes

[Listagem dos Commits realizados](https://github.com/Departamento-de-Engenharia-Informatica/sem4pi-22-23-20/issues/NUMERO_DA_ISSUE)

## 6. Integração/Demonstração

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observações

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*