import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class JavaTest {

	List<String> myArrayList = new ArrayList<String>();
	 
	@BeforeClass
	public void setup() {
		myArrayList.add("Chrome");
		myArrayList.add("FireFox");
		myArrayList.add("IE");
		myArrayList.add("Safari");
		myArrayList.add("Chrome");
	}
	

	/**
	 * Testing general Java String function knowledge
	 */

	@Test(priority=1)
	public void funWithJavaStrings() {		
		
		String companyName = "Dom & Tom Inc.";
		// Assert that the word 'Dom' is present in companyName string
		
	    Assert.assertTrue(companyName.contains("Dom"), "The word Dom is present in comapnyName string..!!");
	    System.out.println("The word Dom is present in comapnyName string!!");
		String name1 = "Netflix";
		String name2 = "NETFLIX";
		
		//System.out.print("Both string are equal or not ==>"+name1.equals(name2));
		// Assert that name1 equals name2 regardless of case and leading/trailing spaces
		Assert.assertTrue(name1.trim().toLowerCase().equals(name2.trim().toLowerCase()), "name1 and name2 are equal regardless of case and leading / trailing spaces");
		System.out.print("Bothe name1 and name2 strings are equal." + "\n");
		
		String intValue1 = "100";
		String intValue2 = "20";
		
		int i = Integer.parseInt(intValue1);
		int j = Integer.parseInt(intValue2);
		int k = i + j ;
		
		System.out.println("Sum of intValue1 and intValue2 is : "+ k);
		// Convert the above 2 strings to integer values and display the sum
	}

	/**
	 * Testing knowledge of java Lists. The list 'myArrayList' has already been
	 * created and populated in @before method. Follow steps outlined below.
	 */

	@Test(priority=2)
	public void funWithArrayLists() {

		// Step 1 display the number of elements in myArrayList
		
		System.out.println("Number of elements in myArrayList is : "+myArrayList.size());

		// Step 2 using enhanced for-loop loop thru myArrayList and display all values to console
        int i = 1;
		for(String s : myArrayList){
			System.out.println("value"+i+ "is"+s);
			i++;
		}

		// Step 3 Display the 3rd element in myArrayList
		
		System.out.println("Third element in the array list is : "+myArrayList.get(2));
		
		/**
		 * Step 4 Loop thru myArrayList to determine if any elements value = 'IE'
		 * if yes, display 'IE found @ index' and the index number in the  console then exit the loop	
		 */
		
		for(int j=0;i < myArrayList.size();j++){
			
			if(myArrayList.get(j).equals("IE")){
				
				System.out.println("IE found @ index "+i);
				break;
			}
		}

		
		/**
		 * Step 5 Loop thru myArrayList to determine if any list elements value = 'Opera'
		 * if not , display 'Opera not found'
		 */
		boolean found = false;
		for(int j=0;i < myArrayList.size();j++){
			
			if(myArrayList.get(j).equals("Opera")){
				
				System.out.println("Opera found @ index "+i);
				found = true;
			}
		}
		
		if(!found){
			System.out.println("Opera not found");
		}
		
	}	 

	/**
	 * Testing knowledge of java HashMaps Follow steps outlined below
	 */

	@Test(priority=3)
	public void funWithHashMaps() {
		
		HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();
		
		/*
		 * Step 1 Load the following into ' myHashMap'
		 * 
		 * Key: = 1 Value: = "XP" 
		 * Key: = 2 Value: = "WIN7" 
		 * Key: = 3 Value: = "WIN8"
		 */
		
		myHashMap.put(1, "XP");
		myHashMap.put(2, "WIN7");
		myHashMap.put(3, "WIN8");
		
		// Step 2 Display to console the value associated with key 2
		
		System.out.println("Value associated with key 2 is : "+myHashMap.get(2));
		
		// Step 3 Display the number of elements in myHashMap
		
		System.out.println("Number of elements in myHashMap is : "+myHashMap.size());
		
		// Step 4 Remove the last element in myHashMap and display the number of elements in myHashMap

		int sizeOfTheMap = myHashMap.size();
		System.out.println("last element in the myHashMap is : "+myHashMap.get(sizeOfTheMap)+"\n");
		System.out.println("Removing last element in the myHashMap " + myHashMap.remove(sizeOfTheMap)+"\n");
		System.out.println("Number of elements after remove last element is "+myHashMap.size());
	}

	/**
	 * Testing knowledge of calling and processing a RESTFUL WebService call using Apache HttpClient 
	 * Follow the steps outlined below
	 * @throws IOException 
	 * @throws ClientProtocolException
	 */

	@Test(priority=4)
	public void funWithWebServices() throws ClientProtocolException, IOException {
	 
		String webServiceUrl = "http://api.geonames.org/cities?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo";
		
		// Step 1 Create instance of httpClient
		@SuppressWarnings({ "deprecation", "resource" })
		HttpClient httpClient = new DefaultHttpClient();
		 	
		/*
   		 * Step 2 Create the Get Request, call it myGetRequest using the HttpGet
		 * class and webServiceUrl
 	   	 */ 
		
		        
		        HttpGet getRequest = new HttpGet(webServiceUrl);
		        
		        /*
				 * Step 3 Using the httpClient object created in step 1 execute
				 * myGetRequest and save the HttpResponse to myHttpResponse
		 		 */
		        HttpResponse myHttpResponse = httpClient.execute(getRequest);
		         
		       
		        // Step 4 Using myHttpResponse display the statuscode and ReasonPhrase to console

				System.out.println("My response===>"+myHttpResponse.toString());
				
		        int statusCode = myHttpResponse.getStatusLine().getStatusCode();
		        System.out.println("Status code : "+statusCode);
		       
	    
 	    /*******EXTRA CREDIT ****** 
	  	* Process the myHttpResponse and display the JSON to the console
	  	* ...hint the response content is returned in myHttpResponse.getEntity().getContent()  
		* use BufferedReader
	  	*/
		        
		        InputStream httpEntity = myHttpResponse.getEntity().getContent();
		     
		       
		        
		        BufferedReader streamReader = new BufferedReader(new InputStreamReader(httpEntity));
		        StringBuilder responseStrBuilder = new StringBuilder();

		        String inputStr;
		        while ((inputStr = streamReader.readLine()) != null){
		            responseStrBuilder.append(inputStr);
		        }

		        JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
		        
		        System.out.println("Output as JSON is : "+ jsonObject);
		        
		        
	}

	/**
	 * Testing knowledge of java HashSets Follow steps outlined below
	 * 
	 */
	@Test(priority=5)
	public void funWithHashSets() {

		// * Step 1 Create a HashSet of String objects called myHashSet
		Set<String> myHashSet = new HashSet<String>();

		/*
		 * Step 2 add the following String objecta to myHashSet "XP" "WIN7"
		 * "WIN8" "Safari" "XP"
		 */
		
		myHashSet.add("XP");
		myHashSet.add("WIN7");
		myHashSet.add("WIN8");
		myHashSet.add("Safari");
		myHashSet.add("XP");
		
		System.out.println("Number elements in my hashset : "+myHashSet.size()+"\n");
		
		/* 
		 * Step 3 Display to console all the values of myHashSet ... hint use iterator
		 */	
		
		Iterator<String> itr = myHashSet.iterator();
		int i = 1;		
		while(itr.hasNext()){
			
				System.out.println("value "+i+"is"+itr.next()+"\n");
				i++;
		}
        
		// Step 4 Remove from myHashSet where String = 'XP"
		Iterator<String> itr1 = myHashSet.iterator();
		while(itr1.hasNext()){
			
			if(itr1.next() == "XP"){
				myHashSet.remove(itr1.next());
				
			}
				
		}

		// Step 5 Display to console the number of elements in myHashSet
	
		System.out.println("Number elements in my hashset after delete XP : "+myHashSet.size()+"\n");
	}	
}