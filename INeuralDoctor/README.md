![logo](https://i.ibb.co/VBcZVYF/jujujub.jpg)
# Componente `INeuralDoctor`

Campo | Valor
----- | -----
Classe | `NewSmartDoctor.java`
Autores | `Gabriel Félix`
Objetivo | `Gerar uma rede neural para ser utilizada pelo Doutor no diagnóstico do paciente`
Interface | `INewDoctor.java`
~~~
package org.encog.examples.guide.classification;

public interface INewDoctor extends IEnquirer, IResponderReceptacle, ITableProducerReceptacle {
    public void treinarDoutor();
    public void diagnosticar(ArrayList<String> sintomas);
}


~~~

### Classe `NewSmartDoctor`
Classe doutor inteligente, implementação de um doutor que se utiliza de rede neural do tipo Feed Foward para diagnosticar pacientes.

Método | Objetivo
-------| --------
`importData` | importar a matriz de sintomas (.csv) do HD já convertida em valores decimais (true -> 1.0 e false -> 0.0) para treinar a rede neural.
`diagnosticar` | recebe uma ArrayList de Strings com o sintomas do paciente para analisar, a partir de um modelo já treinado, qual é a doença do paciente. O método faz a comparação entre a resposta dada pelo doutor e a doença do paciente. Obviamente quanto melhor forem os dados fornecidos (# de casos), melhor será a acurácia do doutorInteligente. 
`treinarDoutor` | implementação da rede neural, onde a partir da matriz de sintomas e doenças é gerado um modelo baseado na rede neural Feedfoward (sem cíclos entre os nós dos layers). O método é chamado na main e não recebe nenhum parâmetro, ela gera um modelo para ser utilizado no método diagnosticar() e no final atualiza os atributos do doutor com uma rede neural já treinada.
`startInterview` | inicia a entrevista com um paciente, chamando o método diagnosticar no final.

### Classe `Patient`
Classe implementada pelo professor André Santachè, porém com a adição de um novo método.

Método | Objetivo
-------| --------
`askSymp` | Questionamento do doutor em relação aos sintomas do paciente, que ao invés de responder apenas "yes" ou "no", ele responde variações de respostas afirmativas ou negativas.

<p align="center"> 
<img src="https://i.ibb.co/F4THmCJ/Untitled-Diagram.png">
</p>
