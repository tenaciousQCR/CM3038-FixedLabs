package cm3038.lab06.tictactoe;

import java.util.*;
import cm3038.search.Action;
import cm3038.search.ActionStatePair;
import cm3038.search.adversarial.*;

/**
 * This class extends MiniMaxSearch to include Alpha-Beta pruning.
 * @author kit
 *
 */
public class TttAlphaBetaProblem extends TttProblem
{
    /**
     * This updated version of search(...) calls maxValue(...) and minValue(...) with
     * the default values of alpha and beta.
     * @param state The current state of the game.
     * @param role The player's role. i.e. max or min.
     */
    @Override
    public ActionScorePair search(cm3038.search.adversarial.State state, PlayerRole role)
    {
        this.nodeVisited = 0;           //reset node count to 0
        
        if (role == PlayerRole.MAX) {   //base on the role, call the appropriate method
            return maxValue(state, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }
        
        if (role == PlayerRole.MIN) {
            return minValue(state, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }
        
        return null;
    }

    /**
     * This method find the score and action of a max node with the given alpha and beta value.
     * @param state The current state of the game.
     * @param alpha The alpha value.
     * @param beta The beta value.
     * @return The best action as an action-score pair.
     */
    protected ActionScorePair maxValue(State state, double alpha, double beta) {
        this.nodeVisited++;                                                     //increment node count by 1
        
        if (this.isTerminal(state)) {                                               //if current state is a terminal state
            return new ActionScorePair(null, this.utility(state, PlayerRole.MAX));  //return the utility score in an ActionScorePair. But there is no action to take.
        }

        double score = Double.NEGATIVE_INFINITY;                                    //otherwise need to search children. Set score to -infinity so that any score will be bigger.
        Action action = null;                                                       //initially no action to take
        
        List<ActionStatePair> childrenList = state.successor(PlayerRole.MAX);       //generate all successors of a MAX level
        Object[] childrenArray = childrenList.toArray();                            //convert list of ActionStatePair to an array for easier manipulation
        
        for (int i = 0; i < childrenArray.length; i++) {                                    //loop through all children
            ActionStatePair actionStatePair = (ActionStatePair) childrenArray[i];   //get a child
            State child = (State)actionStatePair.state;                         //cast it to a cm3038.search.adversarial.State object
            double childScore = minValue(child, alpha, beta).score;                         //recursively find min score from this child state
            
            if (score < childScore) {                                               //this child has a higher score. Good!
                score = childScore;                                             //update score to higher children score
                action = actionStatePair.action;                                    //update action to higher score action
            }
            
            //
            //*** Complete the method here!!!
            //*** Test for beta-cutoff.
            //*** It happens if the score of the child is greater than or equal to beta,
            //*** meaning that a min node above will surely ignore this max node.
            //*** So there is no need to continue with the remaining children.
            //*** When this happens, simply return the current action and score in
            //*** a new ActionScorePair object.
            //
            
            alpha = Math.max(alpha, score);                                     //if no beta-cutoff happens, update alpha and continue with other children
        }
        
        return new ActionScorePair(action, score);                              //return ActionScorePair with the max action and score
    }

    /**
     * This method find the score and action of a min node with the given alpha and beta value.
     * @param state The current state of the game.
     * @param alpha The alpha value.
     * @param beta The beta value.
     * @return The best action as an action-score pair.
     */
    protected ActionScorePair minValue(cm3038.search.adversarial.State state, double alpha, double beta)
    {
        this.nodeVisited++;                                                     //increment node count by 1
        
        if (this.isTerminal(state)) {                                               //check for terminal state
            return new ActionScorePair(null, this.utility(state, PlayerRole.MIN));  //if it is a terminal, return score, no action needed
        }
        
        double score = Double.POSITIVE_INFINITY;                                    //otherwise prepare to search
        Action action = null;
        List<ActionStatePair> childrenList = state.successor(PlayerRole.MIN);       //find all successors of a MIN level
        Object[] childrenArray = childrenList.toArray();
        
        for (int i = 0; i < childrenArray.length; i++) {
            //
            //*** Complete the method here!!!
            //*** This is very similar to maxValue(...) but this is a min node.
            //***
            //*** From the childrenArray, take the next child out.
            //*** Cast it to an ActionStatePair object for easier manipulation.
            //*** Find out the action and next state of this child node.
            //*** Recursively call maxValue(...) to get the minimax value of this child.
            //*** See if you need to update score if a child has a lower minimax value (as this is a min node).
            //*** If yes, store the child's score into score, and the action.
            //*** Next check for alpha-cutoff, which happens if the child's score
            //*** is less than or equal to alpha.
            //*** When this happens, it mean a max node above will surely ignore the current
            //*** min node. So there is no need to continue with the remaining children.
            //*** When alpha-cutoff happens, simply return the current action and score as a new ActionScorePair object.
            //*** If no alpha-cutoff happens, update beta if needed (i.e. when a lower score is found from a child).
            //
        }
        
        return new ActionScorePair(action, score);                              //return action and score
    }
}