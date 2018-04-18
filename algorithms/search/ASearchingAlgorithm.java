package algorithms.search;

abstract class ASearchingAlgorithm implements ISearchingAlgorithm {

    @Override
    abstract public Solution solve(ISearchable searchable);

    @Override
    abstract public String getName();

    @Override
    abstract public int getNumberOfNodesEvaluated();
}
