

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testTwoComments()
    {
        SalesItem salesIte1 = new SalesItem("bacon", 100);
        assertEquals(true, salesIte1.addComment("Chicken", "Little objections to bacon.", 5));
        assertEquals(true, salesIte1.addComment("Porky", "This is terrible, I request a vote of no confidence in bacon", 2));
        assertEquals(2, salesIte1.getNumberOfComments());
    }
    
    /*
     * Exercise 7.15.  Tests against inputing an identical author.
     */
    @Test
    public void testAddCommentIdentical()
    {
        SalesItem salesIte1 = new SalesItem("fat lute", 200);
        assertEquals(true, salesIte1.addComment("Toodles", "I found the noodles superb", 5));
        assertEquals(false, salesIte1.addComment("Toodles", "The noodles are atrocious", 1));
        assertEquals(1, salesIte1.getNumberOfComments());
    }
    
    /*
     * Excercise 7.16  Tests the boundaries of the ratings range.
     */
    @Test
    public void testBoundsRatingRange()
    {
        SalesItem salesIte1 = new SalesItem("Insta Hipsta", 1000);
        assertEquals(false, salesIte1.addComment("Sten", "I performed orthology wearing a bowler.", 6));
        assertEquals(false, salesIte1.addComment("Sven", "My safari in khakis was a failure", 0));
        assertEquals(0, salesIte1.getNumberOfComments());
    }
    
    /*
     *  Excercise 7.18
     */
    @Test
    public void testUpvote()
    {
        Comment comment1 = new Comment("Bigglesworth", "The tofu with au jus was exquisite", 5);
        comment1.upvote();
        comment1.upvote();
        assertEquals(2, comment1.getVoteCount());
    }
    @Test
    public void testDownVote()
    {
        Comment commentDownVote = new Comment("Lt Sotherby", "A passable boot soup for the enlisted", 3);
        commentDownVote.upvote();
        commentDownVote.downvote();
        commentDownVote.downvote();
        assertEquals(-1, commentDownVote.getVoteCount());
    }
    
    /* 
     * Excercise 7.19.  Tests whether findMostHelpfulComment works as expected.
     */
    @Test
    public void testMostHelpful()
    {
        SalesItem salesIte1 = new SalesItem("Ancient Aliens", 333);
        assertEquals(true, salesIte1.addComment("Einstein", "Get this man's hair a real job.", 4));
        Comment comment1 = salesIte1.findMostHelpfulComment();
        assertNotNull(comment1);
        assertEquals("Einstein", comment1.getAuthor());
        assertEquals(true, salesIte1.addComment("Tsoukalos", "Lunar cooling is under rated.", 2));
        salesIte1.upvoteComment(1);
        Comment comment2 = salesIte1.findMostHelpfulComment();
        assertNotNull(comment2);
        assertEquals("Tsoukalos", comment2.getAuthor());
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(0);
        Comment comment3 = salesIte1.findMostHelpfulComment();
        assertNotNull(comment3);
        assertEquals("Einstein", comment3.getAuthor());
    }
    
    /*
     * Anything below this point is for Excercise 7.20
     */
    @Test
    public void testValidatingName()
    {
        SalesItem salesIte1 = new SalesItem("Nuclear Easter Egg", 2000);
        assertEquals("Nuclear Easter Egg", salesIte1.getName());
    }

    @Test
    public void testNumberComments()
    {
        SalesItem salesIte1 = new SalesItem("Fish Diviner", 1500);
        salesIte1.addComment("Old Man", "Found fish.  Not good for profit.", 2);
        salesIte1.addComment("Bing Crosbie", "Caught 13 fish in Alaska.", 5);
        assertEquals(2, salesIte1.getNumberOfComments());
    }

    @Test
    public void testPrice()
    {
        SalesItem salesIte1 = new SalesItem("Nuclear Football", 999);
        assertEquals(999, salesIte1.getPrice());
    }

    @Test
    public void testRemoveComment()
    {
        SalesItem salesIte2 = new SalesItem("Land Shark", 2999);
        assertEquals(true, salesIte2.addComment("Brodie", "Going to need a bigger truck", 4));
        assertEquals(true, salesIte2.addComment("Jaws", "Chompetition...", 2));
        assertEquals(2, salesIte2.getNumberOfComments());
        salesIte2.removeComment(0);
        assertEquals(1, salesIte2.getNumberOfComments());
    }
    
    /*
     * Here we test trying to remove a comment that is out of the bounds of the index.
     */
    @Test
    public void testRemoveNegative()
    {
        SalesItem salesIte1 = new SalesItem("HMS Titanic", 400000);
        salesIte1.addComment("Molly Brown", "Will not take another cruise", 1);
        salesIte1.addComment("White Star", "Water Resistant", 5);
        assertEquals(2, salesIte1.getNumberOfComments());
        salesIte1.removeComment(200);
        assertEquals(2, salesIte1.getNumberOfComments());
    }
}