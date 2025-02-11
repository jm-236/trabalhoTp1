AnimalListUI

AnimalListUI é um sistema de gerenciamento para ONGs de adoção de animais, permitindo o controle de animais, adotantes, funcionários e histórico de adoções.
Estrutura do Projeto

O projeto é composto pelos seguintes arquivos e pastas:

    - AnimalListUi.jar – Aplicação principal.
    - adotantes.json – Armazena informações sobre os adotantes.
    - animais.json – Contém os dados dos animais cadastrados.
    - funcionarios.json – Lista de funcionários cadastrados.
    - historico.json – Registro do histórico de adoções.
    - lib/ – Pasta contendo todas as dependências necessárias para rodar a aplicação.
    
Como Executar

Para rodar o projeto, navegue para a pasta 'lib' execute o seguinte comando no terminal:

java -jar AnimalListUi.jar

Certifique-se de que o Java está instalado no seu sistema.

Funcionalidades

    - Cadastro, edição e remoção de animais.
    - Registro e edição de adotantes.
    - Cadastro, visualização e edição de fichas médicas, incluindo geração de PDF.
    - Realização de adoções, consulta de fichas médicas e adoções.
    - Filtros para selecionar animais adotados ou não.
    - Barra de pesquisa por nome, espécie, raça e gênero.
    - Histórico com registro de todas as ações relacionadas a animais, incluindo filtros, métodos de pesquisa, ordenamento e geração de PDF.
    - Cadastro, visualização e edição do perfil de funcionários, com dois tipos de perfil:
        - Funcionário padrão – Acesso às funções gerais do sistema.
        - Veterinário – Além do acesso do funcionário padrão, pode criar e editar fichas médicas veterinárias.
