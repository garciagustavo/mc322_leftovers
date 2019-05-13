# Componente `DataVisualizer`

Campo | Valor
----- | -----
Classe | `DataVisualizer.java`
Autores | `René F. Jallais`
Objetivo | `Visualização de dados`
Interface | `IDataVisualizer`
~~~
public interface IDataPlot {
  String[] requestAttributes();
  String[][] requestInstances();
}
public interface IDataOrganizer {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
public interface IDataVisualizer extends IDataPlot, IDataOrganizer {
}
~~~

## Detalhamento das Interfaces

### Interface `IDataPlot`
`Plotagem de dados: Gráficos, tabelas, mapas e damais componentes visuais estatisticos`.

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IDataOrganizer`
`Organização de dados: Importar e exportar dados, combinação de tabelas, adição e remoção de linhas e/ou colunas, ordenar/agrupar/consultar dados, mapear e reduzir operações`.

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Exemplo:

### Interface `ITableProducer`
Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.

### Interface `IDataSource`
Define o recurso (usualmente o caminho para um arquivo em disco) que é a fonte de dados.

Método | Objetivo
-------| --------
`getDataSource` | Retorna o caminho da fonte de dados.
`setDataSource` | Define o caminho da fonte de dados, informado através do parâmetro `dataSource`.
