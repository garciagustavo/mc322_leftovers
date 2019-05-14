# Componente `DataVisualizer`

Campo | Valor
----- | -----
Classe | `DataVisualizer.java`
Autores | `René F. Jallais`
Objetivo | `Visualização de dados`
Interface | `IDataVisualizer`
~~~
public interface IDataPlot {
  void plotTable(String[][] Dados);
  void plotGraph(String[][] Dados);
}
public interface IDataOrganizer {
  String[][] combineTable(String[][] table1, String[][] table2);
  String[][] addColumn(String[] column);
  String[][] sortTable(String[][] table);
}
public interface IDataVisualizer extends IDataPlot, IDataOrganizer {
}
~~~

## Detalhamento das Interfaces

### Interface `IDataPlot`
`Plotagem de dados: Gráficos, tabelas, mapas e damais componentes visuais estatisticos`.

Método | Objetivo
-------| --------
`<plotTable>` | `Visualização da table fornecida`
`<plotGraph>` | `Visualização em gráfico dos dados fornecidos`

### Interface `IDataOrganizer`
`Organização de dados: Importar e exportar dados, combinação de tabelas, adição e remoção de linhas e/ou colunas, ordenar/agrupar/consultar dados, mapear e reduzir operações`.

Método | Objetivo
-------| --------
`combineTable` | `Retorna a fusão de duas tabelas`
`addColumn` | `adiciona coluna à tabela`
`sortTable` | `Ordena a tabela`
