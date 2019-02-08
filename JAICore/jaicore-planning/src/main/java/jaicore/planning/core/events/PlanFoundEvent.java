package jaicore.planning.core.events;

import jaicore.basic.algorithm.events.SolutionCandidateFoundEvent;
import jaicore.planning.core.Action;
import jaicore.planning.core.EvaluatedPlan;

public class PlanFoundEvent<A extends Action,V extends Comparable<V>> extends SolutionCandidateFoundEvent<EvaluatedPlan<V>> {

	public PlanFoundEvent(String algorithmId, EvaluatedPlan<V> solutionCandidate) {
		super(algorithmId, solutionCandidate);
	}
}
