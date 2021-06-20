package lu.uni.jakarta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lu.uni.jakarta.ComposedDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lu.uni.jakarta.JSONDocument;
import lu.uni.exercises.jakarta.xml.xmlComponents.CubeView;
import lu.uni.exercises.jakarta.xml.xmlComponents.Row;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private String output, path, result, document;
	private CubeView cubeView;
	private String[] years;
	private List<String> inputMonths;
	private String fileName = "statec.xml";
	private JSONDocument doc;
    private Unmarshaller unmarshaller;
    private File f;
    private String longDate, month;

	

	@GetMapping("/getByMonth")
	public Greeting getByMonth(@RequestParam String month) throws FileNotFoundException, JAXBException  {
		inputMonths = new ArrayList();
		URL resource=this.getClass().getClassLoader().getResource(fileName);
		JAXBContext jc = JAXBContext.newInstance(CubeView.class);
		unmarshaller = jc.createUnmarshaller();
		cubeView = (CubeView) unmarshaller.unmarshal(resource);
		longDate = ComposedDate.YeartoYearMonth(month);
		inputMonths.add(longDate);
		document = CreateJsonFromXml(cubeView, inputMonths);
		return new Greeting(counter.incrementAndGet(), String.format(template, document));
		}
	
	@GetMapping("/getRange")
	public Greeting getRange(@RequestParam String fromMonth, String toMonth) throws FileNotFoundException, JAXBException  {
		URL resource=this.getClass().getClassLoader().getResource(fileName);
		JAXBContext jc = JAXBContext.newInstance(CubeView.class);
		unmarshaller = jc.createUnmarshaller();
		inputMonths = ComposedDate.getDatesRange(fromMonth, toMonth);
		cubeView = (CubeView) unmarshaller.unmarshal(resource);
		document = CreateJsonFromXml(cubeView, inputMonths);
		return new Greeting(counter.incrementAndGet(), String.format(template, document));
		}
	
	@GetMapping("/getVariation")
	public Greeting getVariation(@RequestParam String fromMonth, String toMonth) throws FileNotFoundException, JAXBException  {
		URL resource=this.getClass().getClassLoader().getResource(fileName);
		JAXBContext jc = JAXBContext.newInstance(CubeView.class);
		unmarshaller = jc.createUnmarshaller();
		inputMonths = ComposedDate.getDatesRange(fromMonth, toMonth);
		cubeView = (CubeView) unmarshaller.unmarshal(resource);
		doc = ComposedDate.CreateJsonFromXmlCombined(cubeView, inputMonths);
		Gson gson;
    	gson = new GsonBuilder().setPrettyPrinting().create();
    	document = gson.toJson(doc);
		return new Greeting(counter.incrementAndGet(), String.format(template, document));
		}
	
    private String CreateJsonFromXml(CubeView cubeView, List<String> months) {
    	List<JSONDocument> docs;
    	docs = new ArrayList();
    	Gson gson;
    	gson = new GsonBuilder().setPrettyPrinting().create();
    	Row[] rowList;
    	rowList = cubeView.getData().getRows().getRow();
    	JSONDocument entry;    	
    	for (int i=0; i<rowList.length; i++) {
    		for (int j=0; j<months.size(); j++) {
    			if (rowList[i].getRowLabels().getRowLabel().getValue().contains(ComposedDate.YeartoYearMonth(months.get(j)))) {
    	    		entry = new JSONDocument();
    	    		entry.setYear(rowList[i].getRowLabels().getRowLabel().getValue());
    	    		entry.setResidentBorderes((int) Double.parseDouble(rowList[i].getCells().getC()[0].getV()));
    	    		entry.setNonResidentBorderes((int) Double.parseDouble(rowList[i].getCells().getC()[1].getV()));
    	    		entry.setNationalWageEarners((int) Double.parseDouble(rowList[i].getCells().getC()[2].getV()));
    	    		entry.setDomesticWageEarners((int) Double.parseDouble(rowList[i].getCells().getC()[3].getV()));
    	    		entry.setNationalSeflEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[4].getV()));
    	    		entry.setDomesticSelfEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[5].getV()));
    	    		entry.setNationalEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[6].getV()));
    	    		entry.setDomesticEmployment((int) Double.parseDouble(rowList[i].getCells().getC()[7].getV()));
    	    		entry.setNumberUnemployed((int) Double.parseDouble(rowList[i].getCells().getC()[8].getV()));
    	    		entry.setActivePopulation((int) Double.parseDouble(rowList[i].getCells().getC()[9].getV())); 
    	    		docs.add(entry);
    			}
    		}

    	}	
    	return gson.toJson(docs);
    }

}
