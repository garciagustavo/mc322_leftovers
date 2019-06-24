package org.encog.examples.guide.classification;

public class Main {
    public static void main(String args[]) {
        // instanciando o componente DataSet
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("src/zombiebig.csv");

        // instanciando o componente paciente
        IPatient aPatient = new Patient();
        // conectando-o no componente DataSetaPatient.connect(dataset);
        aPatient.connect(dataset);

        // instanciando o componente doutor louco
        INewDoctor SmartDoctor = new NewSmartDoctor();

        // conectando-o ao componente DataSet
        SmartDoctor.connect(dataset);

        // conectando-o ao componente paciente
        SmartDoctor.connect(aPatient);

        // treinar o doutor a partir da tabela de sintomas e doenças
        SmartDoctor.treinarDoutor();

        // iniciar a consulta com o paciente
        SmartDoctor.startInterview();

        System.out.println();

        // gerar um novo paciente para o doutor
        aPatient.connect(dataset);

        // realizar uma nova consulta sem a necessidade de um novo treinamento
        SmartDoctor.startInterview();

        // Para fazer novas consultas basta atualizar o paciente, ou conectar um novo paciente com o doutor
        // e chamar o metodo .startInterview() para realizar uma nova consulta
    }
}
