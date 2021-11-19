package fr.uga.miage.m1.dilemme_g1_1.strategies;

import java.util.List;
 
public interface Strategie {
	
	 Action getAction(List<Action> actions, Action derniereAction);
	
}
