# Grupo Leftovers!
![logo](https://i.ibb.co/8z6F13t/fefe.jpg)

Membros: Gabriel Félix, René F. Jallais, Gustavo Garcia.

# Componente `INeuralDoctor`

Campo | Valor
----- | -----
Classe | `SmartDoctor.java`
Autores | `Gabriel Félix`
Objetivo | `Gerar uma rede neural para ser utilizada pelo Doutor no diagnóstico do paciente`
Interface | `IDoctor.java`
~~~
package org.encog.examples.guide.classification;

import java.util.ArrayList;

public interface IDoctor extends IEnquirer, IResponderReceptacle, ITableProducerReceptacle {
    public void doutorInteligente(String caminho, ArrayList<String> sintomas);
}

~~~

### Classe `SmartDoctor`
Classe doutor inteligente, implementação de um doutor que se utiliza de rede neural para diagnosticar pacientes.

Método | Objetivo
-------| --------
`importData` | importar a matriz de sintomas (.csv) do HD já convertida em valores decimais (true -> 1.0 e false -> 0.0) para treinar a rede neural.
`dadosPlanilha` | importar a  matriz de sintomas (.csv) original do HD para análise qualitativa do doutor (sintomas e doenças).
`doutorInteligente` | implementação da rede neural, onde a partir da matriz de sintomas e doenças é gerado um modelo baseado na rede neural Feedfoward (sem cíclos entre os nós dos layers). O método é chamado na entrevista (startInterview()) e no final faz a comparação entre a resposta dada pelo doutor e a doença do paciente. Obviamente quanto melhor forem os dados fornecidos (# de casos), melhor será a acurácia do doutorInteligente. 
`startInterview` | inicia a entrevista com um paciente.

### Classe `Patient`
Classe implementada pelo professor André Santachè, porém com a adiação de um novo método.

Método | Objetivo
-------| --------
`askSymp` | Questionamento do doutor em relação aos sintomas do paciente, que ao invés de responder apenas "yes" ou "no", ele responde variações de respostas afirmativas ou negativas.

# Componente `DataVisualizer`

Campo | Valor
----- | -----
Classe | `DataVisualizerBean.java`
Autores | `René F. Jallais`
Objetivo | `Organização e visualização de dados`
Interface | `IDataVisualizer`
~~~
public interface IDataPlot {
  void plotTable(String Dados);
  void plotGraph(String Dados);
}
public interface IDataOrganizer {
  String[][] addPatient(String[] patient, String[][] table);
  String[][] sortTable(String dados);
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

# Componente `<IProbOfIllness>`

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
