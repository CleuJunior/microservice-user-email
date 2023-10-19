# Microserviço User

O microserviço User tem como única finalidade cadastrar novos usuários no banco de dados. Após o cadastro ser concluído,
o usuário recebe uma resposta por e-mail do serviço de e-mails.

## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente.

`LINK_MQ` -> Link do servidor do RabbitMQ


## Documentação da API

```http
  POST /api/v1/user
  Content-Type: application/json

  {
    "name": "Nome do Usuário",
    "email": "exemplo@email.com"
  }
```

| Campo   | Tipo     | Descrição                           |
|:--------|:---------|:------------------------------------|
| `name`  | `string` | Nome do usuário **Obrigatório**.    |
| `email` | `string` | Endereço de e-mail **Obrigatório**. |