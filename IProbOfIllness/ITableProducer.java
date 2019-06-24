package earlydiagnosis;

public interface ITableProducer {
  public String[] requestAttributes();
  public String[][] requestInstances();
}