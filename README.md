## Iniciando ##
Sistema de Controle de Estoque foi desenvolvido. Utilizei os seguintes requisitos:

### Utilizei os seguintes requisitos###
* Utilizei o BD H2 do Spring Boot;
* Todos os dados necessários para a execução e utilização do projeto serão enviados junto com o código feito;
* Spring Security para controle de acesso;


### Requisitos funcionais ###
* **1-** O sistema uma tela para permitir o cadastro e edição de produtos com os seguintes campos :
  * _Id_: tem um sequencial único, mostrado somente em modo de edição sem permitir sua alteração;
  * _Código de barras_: Código de barras do produto, sendo um campo do tipo literal. Não existe mais de um produto com o mesmo código de barras;
  * _Nome_: Nome do produto, sendo um campo do tipo literal;
  * _Quantidade mínima_: Quantidade mínima do produto em estoque, sendo um campo do tipo numérico;
  * _Saldo inicial_: Saldo inicial do produto no momento do cadastro, sendo um campo do tipo numérico;
    * Não é possível sua alteração após o cadastro; 
    * Ao cadastrar um valor superior a 0, uma movimentação de _SALDO_INICIAL_ sera criada para o produto;
    * O _Saldo inicial_ não poderá ser inferior a _quantidade mínima_
* **2-** O sistema tem uma tela para permitir o lançamento das movimentações de estoque:
  * _Produto_: Campo para permitir informar/selecionar um produto previamente cadastrado;
  * _Tipo de Movimento_: Os tipos de movimentação possíveis são: _ENTRADA_, _SAÍDA_, _SALDO_INICIAL_, _AJUSTE_ENTRADA_ e _AJUSTE_SAÍDA_; 
    * Somente o _GERENTE_ pode realizar lançamentos do tipo _SALDO_INICIAL_ e _AJUSTE_; 
    * existe no máximo 1 lançamento do tipo _SALDO_INICIAL_ por produto;
    * O lançamento de _SALDO_INICIAL_ somente pode ser realizado se não existirem outros lançamentos para o produto;
    * O lançamento de _AJUSTE_ somente podevser realizado quando existirem outros lançamentos para o produto;
  * _Quantidade_: Quantidade a ser movimentada no estoque. 
    * O sistema não pode permitir lançamentos em que o saldo do produto se torne negativo;
  * _Data_: Data da movimentação.
    * Não pode ter movimentação para um determinado produto anterior a sua criação;
  * _Motivo_: Motivo da Movimentação
  * _Documento_: Documento vinculado a movimentação, mostrar somente quando a movimentação for do tipo _ENTRADA_ ou _SAÍDA_;
* **3-** O sistema tem uma tela para listar as movimentações de estoque com os seguintes campos:
  * Filtros:
    * _Produto_: Permitir filtrar os lançamentos por produto;
    * _Período_: Permitir filtrar os lançamentos de um determinado período;
    * _Tipo de Movimento_: Permitir filtrar os lançamentos de um determinado Tipo de Movimento;
  * Ordenações:
    * _Produto_
    * _Data_
  * Campos da Listagem:
    * _Data do Movimento_
    * _Produto_
    * _Tipo do Movimento_
    * _Documento_
    * _Motivo_
    * _Saldo_: Calculado considerando (Saldo Inicial + Entradas + Ajustes de Entrada - Saídas - Ajustes de Saída);
    * _Situação_: Caso o produto tiver valor para o campo _Quantidade Mínima_, e o _Saldo_ for inferior a ele, mostrar _Inferior ao Mínimo_ do contrário, mostrar _Ok_ 
