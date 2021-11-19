package fr.uga.miage.m1.dilemme_g1_1.strategies;

import java.util.List;

public class ToujoursCooperer implements Strategie {

	public Action getAction(List<Action> actionsAdverse, Action derniereAction) {
		
		return Action.COOPERER;
	}

}
