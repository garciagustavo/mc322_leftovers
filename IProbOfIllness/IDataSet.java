package earlydiagnosis;

public interface IDataSet extends IDataSource, ITableProducer {
    @Override
    public String[] requestAttributes();
    @Override
    public String[][] requestInstances();
}