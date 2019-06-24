package earlydiagnosis;

import java.util.ArrayList;

public class ProbabilisticComponent implements IEarlyDiagnosis{

    private String[]   attributes = null;
    private String[][] instances  = null;

    public ProbabilisticComponent(IDataSet dataset){
        this.attributes = dataset.requestAttributes();
        this.instances  = dataset.requestInstances();
    }

    @Override
    public void calculateProbability(ArrayList<String> symptoms){
        double probability = 0;
        
        // pega nos atributos o índice de cada sintoma à analisar
        ArrayList<Integer> indexes = getSymptomsIndexes(symptoms);
        
        if(indexes.size() != 0){
            // pega nas instâncias as linhas que possuem os sintomas à analisar
            ArrayList<Integer> lines = getDiseasesLines(indexes);
            // conta a totalidade de sintomas possíveis em cada doença (linha)
            ArrayList<Integer> possibleOutcomes = countPossibleOutcomes(lines);
            // casos favoráveis na probabilidade de ser uma doença
            int favorableOutcomes = symptoms.size();
            
            for(int i = 0; i < lines.size(); i++){
                
                probability = ((double)favorableOutcomes/(double)possibleOutcomes.get(i))*100;
                
                if(possibleOutcomes.get(i) != 0){    
                    System.out.print("The patient has a ");
                    System.out.printf("%.2f",probability);
                    System.out.print("% chance of having " + instances[lines.get(i)][attributes.length-1]);
                    System.out.println();
                }
            }
        }
    }
    // conta quantos TRUE possui cada linha selecionada
    private ArrayList<Integer> countPossibleOutcomes(ArrayList<Integer> lines){
        ArrayList<Integer> possibleOutcomes = new ArrayList<Integer>();
        int counter = 0;
        for(int i = 0; i < lines.size(); i++){
            counter = 0;
            for(int j = 0; j < attributes.length-1; j++){
                if(instances[i][j].equals("t"))
                    counter++;
            }
            possibleOutcomes.add(counter);
        }
        return possibleOutcomes;
    }
    // seleciona as linhas que possuem todos os sintomas à analisar
    private ArrayList<Integer> getDiseasesLines(ArrayList<Integer> indexes){
        ArrayList<Integer> lines = new ArrayList<Integer>();
        int counter = 0;
        for(int i = 0; i < instances.length; i++){
            counter = 0;
            for(int j = 0; j < indexes.size(); j++){
                if(instances[i][indexes.get(j)].equals("t"))
                    counter++;
            }
            if(counter == indexes.size())
                lines.add(i);
        }
        return lines;
    }
    // seleciona as colunas de cada sintoma à analisar
    private ArrayList<Integer> getSymptomsIndexes(ArrayList<String> symptoms){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < symptoms.size(); i++){
            for(int j = 0; j < attributes.length-1; j++){
                if(symptoms.get(i).equals(attributes[j])){
                    indexes.add(j);
                    break;
                }
            }
        }
        return indexes;
    }    
}