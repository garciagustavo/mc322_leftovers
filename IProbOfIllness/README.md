# Componente `<IEarlyDiagnosis>`

Campo | Valor
----- | -----
Classe | `ProbabilityComponent.java`
Autores | `Gustavo Garcia`
Objetivo | `A partir de poucos sintomas iniciais, apresentar cada probabilidade das possíveis doenças`
Interface | `IEarlyDiagnosis.java`
~~~
public interface IEarlyDiagnosis {
    public void calculateProbability(String[] symptoms);
}
~~~

### Interface `IEarlyDiagnosis`
A interface auxiliará no diagnóstico precoce das doenças, baseada em poucos sintomas iniciais, entregando probabilidades de possíveis diagnósticos.

Método | Objetivo
-------| --------
`public void calculateProbability(String[] symptoms)` | O método pega um vetor de sintomas iniciais e imprime probabilidades de possíveis doenças.

### Como usar

// Criar um componente que representa seu dataset<br>
IDataSet dataset = new DataSetComponent();

// Importar seu dataset<br>
dataset.setDataSource("caminho-do-seu-dataset.csv");

// Criar um vetor de String com os sintomas iniciais<br>
String sintomas[] = {"sintoma1", "sintoma2",...};

// Criar o componente que calcula as probabilidades no seu dataset<br>
IEarlyDiagnosis prob = new ProbabilisticComponent(dataset);

// Chamar o método e receber a informação<br>
prob.calculateProbability(sintomas);
