package org.tianchi.results.evaluation;


import org.tianchi.results.csv.TianchiResult;

public class FinalScore implements Metrics{
	
	private float score;
	
	private TianchiResult staticresult;
	
	private TianchiResult dynamicresult;
	

	public FinalScore(TianchiResult staticresult, TianchiResult dynamicresult) {
		super();
		this.staticresult = staticresult;
		this.dynamicresult = dynamicresult;
	}

	@Override
	public float getScore() {
		// TODO Auto-generated method stub
		//ConstraintsCheck funtion missing
		
		CostsMetric costs = new CostsMetric(staticresult);
		DistributionMetric distribution = new DistributionMetric(staticresult);
		float scorestatic = costs.getScore() + distribution.getScore();
		
		CostsMetric costsdyn = new CostsMetric(dynamicresult);
		DistributionMetric distributiondyn = new DistributionMetric(dynamicresult);	
		MigrationMetric migration = new MigrationMetric(dynamicresult);
		float scoredynamic = costsdyn.getScore() + distributiondyn.getScore() + migration.getScore();
		
		score = scorestatic + scoredynamic;
		System.out.println("Final Score: Static-"+scorestatic+"  Dynamic-"+scoredynamic+"  Total-"+score);
		return score;
	}

	
}
