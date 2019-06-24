package org.encog.examples.guide.classification;

import java.io.File;
import java.util.ArrayList;

import org.encog.Encog;
import org.encog.ml.MLRegression;
import org.encog.ml.data.MLData;
import org.encog.ml.data.versatile.NormalizationHelper;
import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.columns.ColumnDefinition;
import org.encog.ml.data.versatile.columns.ColumnType;
import org.encog.ml.data.versatile.sources.CSVDataSource;
import org.encog.ml.data.versatile.sources.VersatileDataSource;
import org.encog.ml.factory.MLMethodFactory;
import org.encog.ml.model.EncogModel;
import org.encog.util.csv.CSVFormat;

// Implementação da classe NewSmartDoctor utilizando redes neurais através da biblioteca externa Encog.
// Utilizando do Quick Guide para o uso de redes neurais e classificação
// https://s3.amazonaws.com/heatonresearch-books/free/encog-3_3-quickstart.pdf

public class NewSmartDoctor implements INewDoctor {

    private ITableProducer producer;
    private IResponder responder;
    private VersatileMLDataSet data;
    private MLRegression bestMethod;

    public void connect(ITableProducer producer) {
        this.producer = producer;
    }

    public void connect(IResponder responder) {
        this.responder = responder;
    }

    public File importData(String path) {
        File doctorFile = new File(path);

        return doctorFile;
    }

    public void treinarDoutor() {
        // receber o endereço do arquivo .CSV da tabela de sintomas e doenças
        String caminho = ((IDataSet) producer).getDataSource();
        String attributes[] = producer.requestAttributes();

        // reescrever a matriz de sintomas com 1 ou 0 ao invés de T ou F
        CsvRewrite lerDados = new CsvRewrite();
        lerDados.rewriteData(caminho);

        // importar o arquivo .CSV para análise do Encog
        File doctorFile = importData("src/newDataSet.csv");

        // Definir o tipo de arquivo e o formato das colunas.
        VersatileDataSource source = new CSVDataSource(doctorFile, false, CSVFormat.DECIMAL_POINT);

        VersatileMLDataSet data = new VersatileMLDataSet(source);

        for (int a = 0; a < attributes.length-1; a++) {
            data.defineSourceColumn(attributes[a], a, ColumnType.continuous);
        }

        // Definir a coluna de doenças que queremos fazer a previsão
        ColumnDefinition outputColumn = data.defineSourceColumn("diagnostic", attributes.length-1, ColumnType.nominal);

        // Analisar os dados, definindo os máx/min/média de cada coluna
        data.analyze();

        // Mapear a coluna de doenças para ser o output do Modelo e os sintomas o input
        data.defineSingleOutputOthersInput(outputColumn);

        // Criar uma rede neural do tipo Feed Foward (conexões entre os nós não foram um círculo).
        EncogModel model = new EncogModel(data);
        model.selectMethod(data, MLMethodFactory.TYPE_FEEDFORWARD);

        // Normalização automática dos dados baseado no tipo de rede neural escolhida acima (Feed Foward)
        data.normalize();

        // Ultima validação dos dados fornecidos para verificação do modelo
        model.holdBackValidation(0.3, true, 1001);

        // Escolher o melhor tipo de treino para esse modelo (F.F.)
        model.selectTrainingType(data);

        // Avaliação do modelo por cross-validation para avaliar eficácia da rede neural
        MLRegression bestMethod = (MLRegression) model.crossvalidate(5, true);

        // Salvar os dados da rede neural como atributos da classe para serem utilizadas no diagnóstico
        this.data = data;
        this.bestMethod = bestMethod;
    }

    public void diagnosticar(String caminho, ArrayList<String> sintomas) {
        // Pegar os parâmetros normalizados do modelo e utilizar o arquivo .CSV para aplicar no modelo
        // Poderiamos também utilziar uma nova tabela desconhecida .CSV com dados referentes ao mesmo tipo
        // de sistuação analisadas (sintomas x doenças) para fazer a classificação baseada no treino anterior.

        NormalizationHelper helper = this.data.getNormHelper();
        MLData input = helper.allocateInputVector();

        String attributes[] = producer.requestAttributes();

        String linee[] = new String[sintomas.size()];

        // Pegando o sintomas do paciente e transformando em um vetor para análise do modelo
        for (int a = 0; a < sintomas.size(); a++) {
            linee[a] = sintomas.get(a);
        }

        helper.normalizeInputVector(linee, input.getData(), false);
        MLData output = this.bestMethod.compute(input);
        String docChosen = helper.denormalizeOutputVectorToString(output)[0];

        // Questionáros ao paciente
        for (int a = 0; a < attributes.length-1; a++) {
            System.out.println("Question: Do you have " + attributes[a] + "?: " + responder.askSymp(attributes[a]));
        }

        System.out.println("Disease diagnosis: " + docChosen);
        boolean result = responder.finalAnswer(docChosen);
        System.out.println("Result: " + ((result) ? "I am right =)" : "I am wrong =("));
        if (!result) {
            System.out.println("The patient unfortunately died from this bad diagnosis... The doctor is fired and his wife, Karen, left him with the children.");
        }

        // Encerrar o modelo treinado
        Encog.getInstance().shutdown();
    }

    public void startInterview() {
        String attributes[] = producer.requestAttributes();
        ArrayList<String> sintomas = new ArrayList<String>();

        // conversão dos sintomas do paciente para um ArrayList
        for (int a = 0; a < attributes.length-1; a++) {
            if ((responder.ask(attributes[a])).equals("yes"))
                sintomas.add("1.0");
            else
                sintomas.add("0.0");
        }
        // Diagnosticar o paciente baseado no modelo já treinado.
        diagnosticar(((IDataSet) producer).getDataSource(), sintomas);
    }
}
