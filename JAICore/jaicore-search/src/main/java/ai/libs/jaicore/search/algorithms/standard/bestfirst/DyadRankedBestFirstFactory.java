package ai.libs.jaicore.search.algorithms.standard.bestfirst;

import ai.libs.jaicore.search.model.travesaltree.ReducedGraphGenerator;
import ai.libs.jaicore.search.probleminputs.GraphSearchWithSubpathEvaluationsInput;

/**
 * Factory for a best first search with a dyad ranked OPEN list.
 *
 * @author Helena Graf
 *
 * @param <N>
 * @param <A>
 * @param <V>
 */
public class DyadRankedBestFirstFactory<N, A, V extends Comparable<V>> extends StandardBestFirstFactory<N, A, V> {

	/**
	 * the used config
	 */
	private IBestFirstQueueConfiguration<GraphSearchWithSubpathEvaluationsInput<N, A, V>, N, A, V> openConfig;

	/**
	 * Construct a new factory that makes best first search objects using the given
	 * config.
	 *
	 * @param openConfig
	 *            parameters for the OPEN list ranking
	 */
	public DyadRankedBestFirstFactory(
			final IBestFirstQueueConfiguration<GraphSearchWithSubpathEvaluationsInput<N, A, V>, N, A, V> openConfig) {
		this.openConfig = openConfig;
	}

	@Override
	public BestFirst<GraphSearchWithSubpathEvaluationsInput<N, A, V>, N, A, V> getAlgorithm() {
		// Replace graph generator in problem
		this.setProblemInput(new GraphSearchWithSubpathEvaluationsInput<>(
				new ReducedGraphGenerator<>(this.getInput().getGraphGenerator()), this.getInput().getGoalTester(), this.getInput().getPathEvaluator()));

		// Configure and return best first
		BestFirst<GraphSearchWithSubpathEvaluationsInput<N, A, V>, N, A, V> bestFirst = super.getAlgorithm();
		this.openConfig.configureBestFirst(bestFirst);
		return bestFirst;
	}
}
