# Componente `DataVisualizer`

Campo | Valor
----- | -----
Classe | `DataVisualizerBean.java`
Autores | `René F. Jallais`
Objetivo | `Organização e visualização de dados`
Interface | `IDataVisualizer`
~~~
public interface IDataPlot {
  void plotTable(String path);
  void plotTable(Table table);
  void plotTable(String[][] matrix);
  void plotGraph(String path, String symptom);
}

public interface IDataOrganizer {
  String[][] addPatient(String[] patient, String[][] matrix);
  String[][] sortTable(String path);
}

public interface IDataVisualizer extends IDataPlot, IDataOrganizer {
}
~~~

## Detalhamento das Interfaces

### Interface `IDataPlot`
`Printa tabelas formatadas a partir de arquivos .csv;
Plota gráficos para melhor compreensão de dados visuais estatisticos`.

Método | Objetivo
-------| --------
`plotTable` | `Visualização da tabela fornecida em arquivo .csv`
`plotGraph` | `Visualização em gráfico dos dados fornecidos`

### Interface `IDataOrganizer`
`Organização de dados: Adição de novos pacientes(linhas) na tabela e ordenação da tabela`.

Método | Objetivo
-------| --------
`addPatient` | `adiciona uma linha que representa um novo paciente à tabela`
`sortTable` | `Ordena a tabela`
