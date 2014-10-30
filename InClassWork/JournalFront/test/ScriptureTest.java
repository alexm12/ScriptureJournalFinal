/*
 * Alex Mitchell
 * 
 * Collaborators: Ashley Hort, Paul O'Niell, Cameron Lilly
 */
import java.io.BufferedReader;
import java.io.File; 
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import milestone.pkg2.Entry;
import milestone.pkg2.JournalFront;
import milestone.pkg2.Scripture;
import milestone.pkg2.Topic;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Alex
 */
public class ScriptureTest {
    
    public ScriptureTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void scriptureTest(){
        Scripture scripture = new Scripture();
       
        String validBooks = "Nephi";
        scripture.setBook("Nephi");
        scripture.setChapter(3);
        scripture.setStartVerse(10); 
        Assert.assertEquals(scripture.getBook(), validBooks);
        Assert.assertTrue(scripture.getChapter() == 3);
        Assert.assertTrue(scripture.getStartVerse() == 10);
    }
    
    @Test
    public void dateFindTest(){
        Calendar date = new GregorianCalendar(2014, 10, 10);
        Entry entry = new Entry();
        entry.setEntry("RIGHT DATE");
        entry.setDate(date);
        Calendar date2 = new GregorianCalendar(2014, 10, 11);
        Entry entry2 = new Entry();;
        entry2.setDate(date2);
        entry2.setEntry("WRONG DATE");
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        entries.add(entry2);
        JournalFront journal = new JournalFront();
        journal.setEntries(entries);
        Entry found;
        found = journal.getEntryByDate(entry.getDateString());
        Assert.assertEquals(found, entry);
        
        
    }
    
    @Test
    public void topicTest(){
        Topic topic = new Topic();
        
        String validTopics = "Faith";
        
        topic.setTopic("Faith");
        Assert.assertEquals(topic.getTopic(), validTopics);
    }
    
    @Test
    public void tryFile(){
        String filename = "file";
        try (BufferedReader file = new BufferedReader(new FileReader(filename)))
        {
            
        }
        catch (IOException error){
  
        }
        File file = new File(filename);
        Assert.assertTrue(file.exists());
    } 
    
           
    @Test 
    public void testGenEntry(){
        Entry curEntry = new Entry();
        String test = "test";
        curEntry.setEntry(test);
        Calendar newDate = new GregorianCalendar();
        curEntry.setDate(newDate);
        Assert.assertEquals(curEntry.getEntry(), test);
        Assert.assertEquals(curEntry.getDate(), newDate);
    }
        
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
