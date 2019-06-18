# Grupo Leftovers!

# Componente `INeuralDoctor`

Campo | Valor
----- | -----
Classe | `INeuralDoctor.java`
Autores | `Gabriel Félix`
Objetivo | `Gerar uma rede neural para ser utilizada pelo Doutor no diagnóstico do paciente`
Interface | `INeuralDoctor.java`
~~~
import java.io.File;
import java.util.Arrays;
import org.encog.*;

public interface INeuralDoctor {
    public File importData(String[] args);
    public EncogModel analyseData (File dataFile, int numColumns);
    public MLRegression generateNeuralNetwork (EncogModel model);
    public void analyseCase (MLRegression neuralNet, Patient namePaciente);
    public void endDiagnostics (File dataFile);
}
~~~

### Interface `INeuralDoctor`
Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

Método | Objetivo
-------| --------
`importData` | importar a matriz de sintomas (.csv) do HD ou de alguma URL (futuramente pode-se utilizar a componente já pronta DataSource).
`analyseData` | através da biblioteca externa "Encog" analisar o arquivo (.csv): examinando cada coluna de sintoma e mapeando cada linha correspondente a uma doença. Por fim, gerar uma rede neural do tipo feed forward.
`generateNeuralNetwork` | normalizar os dados do modelo e avaliar o melhor método para ser implementado na rede.
`analyseCase` | recebe um paciente e a rede neural como parâmetros para diagnosticá-lo (vai ser conectado ao doutor).
`endDiagnostics` | apaga o arquivo (.csv) e encerra as operações da rede neural.

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
`Printa tabelas formatadas a partir de arquivos .csv; Plota gráficos para melhor compreensão de dados visuais estatisticos`.

Método | Objetivo
-------| --------
`plotTable` | `Visualização da table fornecida em arquivo .csv`
`plotGraph` | `Visualização em gráfico dos dados fornecidos`

### Interface `IDataOrganizer`
`Organização de dados: Adição de novos pacientes(linhas) na tabela, ordenação da tabela`.

Método | Objetivo
-------| --------
`addPatient` | `adiciona uma linha que representa um novo paciente à tabela`
`sortTable` | `Ordena a tabela`

# Componente `IProbOfIllness`

Campo | Valor
----- | -----
Classe | `<...>`
Autores | `<Gustavo Garcia>`
Objetivo | `<A partir de poucos sintomas iniciais, apresentar cada probabilidade das possíveis doenças>`
Interface | `<IProbability.java>`
~~~
public interface IProbability {
    public String[] diagnosis(File dataFile);
}
~~~

### Interface `IProbability`
A interface auxiliará no diagnóstico precoce das doenças, baseada em poucos sintomas iniciais, entregando probabilidades de possíveis diagnósticos.

Método | Objetivo
-------| --------
`diagnosis` | importar a matriz de sintomas (.csv) do HD ou de alguma URL (futuramente pode-se utilizar a componente já pronta DataSource) e devolver um diagnóstico probabilístico.
