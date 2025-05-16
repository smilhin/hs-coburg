package localsearch;

import java.util.Collection;

public interface ProblemState<P extends ProblemState<P>> {
    Collection<P> getSuccessors();
    double evaluate();
}
