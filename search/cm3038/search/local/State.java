package cm3038.search.local;

import java.util.*;

/**
 * This interface defines the methods required on a problem state.
 * Any class that represents a problem state must implement this interface.
 *
 * @author Kit-ying Hui
 */
public interface State
{
/**
 * Converts the state into a {@link String}. This method controls how a state will be printed.
 * @return A {@link String} representation of the state.
 */
public String toString();

/**
 * Return all neighbouring states of the current one.
 * These neighbours are obtained by changing each variable in the current state.
 * 
 * @return All neighbouring states as a Set.
 */
public Set<State> neighbours();
} //end interface
