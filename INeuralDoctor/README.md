![logo](https://i.ibb.co/VBcZVYF/jujujub.jpg)
# Componente `<INeuralDoctor>`

Campo | Valor
----- | -----
Classe | `<INeuralDoctor.java>`
Autores | `<Gabriel Félix>`
Objetivo | `<Gerar uma rede neural para ser utilizada pelo Doutor no diagnóstico do paciente>`
Interface | `<INeuralDoctor.java>`
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
