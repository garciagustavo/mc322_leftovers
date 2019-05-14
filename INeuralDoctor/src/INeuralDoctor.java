import java.io.File;
import java.util.Arrays;
import org.encog.*;

public interface INeuralDoctor {
    // importar a matriz de sintomas (.csv) do drive do computador ou de alguma URL
    // (futuramente pode-se utilizar a componente DataSource).
    public File importData(String[] args);
    // através da biblioteca externa "Encog" analisar o arquivo (.csv): examinando cada coluna de sintoma e
    // mapeando cada linha correspondente a uma doença. Por fim, gerando uma rede neural do tipo feed forward
    public EncogModel analyseData (File dataFile, int numColumns);
    // normalizar os dados do modelo e avaliar o melhor método para ser implementado na rede.
    public MLRegression generateNeuralNetwork (EncogModel model);
    // recebe um paciente como parâmetro e a rede neural pronta, ao fim de diagnosticá-lo
    // (vai ser conectado ao doutor).
    public void analyseCase (MLRegression neuralNet, Patient namePaciente);
    // apaga o arquivo (.csv) e encerra as operações da rede neural.
    public void endDiagnostics(File dataFile);
}
