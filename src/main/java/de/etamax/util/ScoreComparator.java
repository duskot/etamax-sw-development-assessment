package de.etamax.util;

import de.etamax.model.Player;

import java.util.Comparator;

/**
 * Class to compare score objects which implements
 * comparator interface and override method compare.
 *
 * @author Dusko Tesanovic
 */
public class ScoreComparator implements Comparator<Player> {

    /**
     * This overridden method compare two objects Player
     * types according to score, and if score is same,
     * then according to time.
     *
     * @param o1 the first Player object to be compared
     * @param o2 the second Player object to be compared
     * @return the ordered objects compared with two criteria
     */
    @Override
    public int compare(Player o1, Player o2) {

        // if the score different the method return objects compared score in descending order
        if (o1.getScore() != o2.getScore()) {
            return o2.getScore() - o1.getScore();
        } else {
            // if the score same the method return objects compared by time in ascending order
            return o1.getTime() - o2.getTime();
        }
    }
}
