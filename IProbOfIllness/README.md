# Componente `<IEarlyDiagnosis>`

Campo | Valor
----- | -----
Classe | `<ProbabilityComponent.java>`
Autores | `<Gustavo Garcia>`
Objetivo | `<A partir de poucos sintomas iniciais, apresentar cada probabilidade das possíveis doenças>`
Interface | `<IEarlyDiagnosis.java>`
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


