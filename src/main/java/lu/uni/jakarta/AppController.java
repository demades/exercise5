package lu.uni.jakarta;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lu.uni.exercises.jakarta.xml.xmlComponents.CubeView;

@RestController
public class AppController {
	
	private String document;
	private CubeView cubeView;
	private List<String> inputMonths;
	private String fileName = "statec.xml";
	private JSONDocument doc;
    private Unmarshaller unmarshaller;

	
    
	@GetMapping("/getByMonth")
	@ApiOperation(value = "Find information of a date in particular with format YYYYMM")
	public String getByMonth(@ApiParam(value = "month value with format YYYYMM  you want to retrieve", required = true) 
	@RequestParam String month) throws FileNotFoundException, JAXBException  {
		inputMonths = new ArrayList();
		URL resource=this.getClass().getClassLoader().getResource(fileName);
		JAXBContext jc = JAXBContext.newInstance(CubeView.class);
		unmarshaller = jc.createUnmarshaller();
		cubeView = (CubeView) unmarshaller.unmarshal(resource);
		inputMonths.add(month);
		document = Utils.CreateJsonFromXml(cubeView, inputMonths);
		return document;
		}
	
	@GetMapping("/getRange")
	@ApiOperation(value = "Find information of a dates range with format YYYYMM")
	public String getRange(@ApiParam(value = "month value with format YYYYMM  you want to retrieve", required = true)
	@RequestParam String fromMonth, String toMonth) throws FileNotFoundException, JAXBException  {
		URL resource=this.getClass().getClassLoader().getResource(fileName);
		JAXBContext jc = JAXBContext.newInstance(CubeView.class);
		unmarshaller = jc.createUnmarshaller();
		inputMonths = Utils.getDatesRange(fromMonth, toMonth);
		cubeView = (CubeView) unmarshaller.unmarshal(resource);
		document = Utils.CreateJsonFromXml(cubeView, inputMonths);
		return document;
		}
	
	@GetMapping("/getVariation")
	@ApiOperation(value = "Get information of the difference of two dates")
	public JSONDocument getVariation(@RequestParam String fromMonth, String toMonth) throws FileNotFoundException, JAXBException  {
		URL resource=this.getClass().getClassLoader().getResource(fileName);
		JAXBContext jc = JAXBContext.newInstance(CubeView.class);
		unmarshaller = jc.createUnmarshaller();
		inputMonths = Utils.getDatesRange(fromMonth, toMonth);
		cubeView = (CubeView) unmarshaller.unmarshal(resource);
		doc = Utils.CreateJsonFromXmlCombined(cubeView, inputMonths);
		Gson gson;
    	gson = new GsonBuilder().setPrettyPrinting().create();
    	document = gson.toJson(doc);
		return doc;
		}
}