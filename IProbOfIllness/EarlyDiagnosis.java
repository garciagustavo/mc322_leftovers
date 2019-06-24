package earlydiagnosis;

import java.util.Scanner;
import java.util.ArrayList;

public class EarlyDiagnosis {

    public static void main(String[] args) {
        
        int i                      = 0;
        String path                = null;
        String sintoma             = null;
        ArrayList<String> sintomas = new ArrayList<String>();
        IDataSet dataset           = new DataSetComponent();
        Scanner sc                 = new Scanner(System.in);
        
        System.out.print("Entre com o caminho do Dataset: ");
        path = sc.next();
        dataset.setDataSource(path);
        
        System.out.println("Digite os sintomas (Enter após cada um) ou digite # para terminar");
        System.out.println("Sintoma " + i + ": ");
        sintoma = sc.next();
        
        while(!sintoma.equals("#")){
            sintomas.add(sintoma);
            i++;
            System.out.print("Sintoma " + i + ": ");
            sintoma = sc.next();
        }
        sc.close();
        
        if(sintomas != null){
            IEarlyDiagnosis prob = new ProbabilisticComponent(dataset);
            prob.calculateProbability(sintomas);
        }   
    }
}