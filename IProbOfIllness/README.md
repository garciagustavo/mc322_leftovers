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
