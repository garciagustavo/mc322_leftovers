![logo](https://i.ibb.co/VBcZVYF/jujujub.jpg)
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
Classe implementada pelo professor André Santachè, porém com a adição de um novo método.

Método | Objetivo
-------| --------
`askSymp` | Questionamento do doutor em relação aos sintomas do paciente, que ao invés de responder apenas "yes" ou "no", ele responde variações de respostas afirmativas ou negativas.
