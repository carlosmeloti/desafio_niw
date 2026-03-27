## Como executar o projeto

1. Clone o repositório
2. Execute a aplicação pelo Maven ou pela IDE
3. A aplicação subirá com banco H2 em memória
4. O Flyway irá limpar e recriar o banco automaticamente a cada inicialização

## Testando a API

O projeto inclui uma collection para facilitar os testes.

### Collection
- Local: `src/main/collection`
- Importe o arquivo no Postman ou ferramenta equivalente

### Observações
- A base é reiniciada a cada startup
- Os dados iniciais são carregados automaticamente pelo Flyway
- Se houver autenticação, use as credenciais configuradas no projeto