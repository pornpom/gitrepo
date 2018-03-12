
package web;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.inject.*;
import javax.ws.rs.*;
import javax.mvc.*;
import javax.mvc.engine.*;
import javax.mvc.annotation.Controller;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/shop") @Controller 
    public class Shop {
    @Inject Models model;

        

        


        
        @GET @Path("/read")
        public String ShowRead(){
             ArrayList a = new ArrayList();
       String path = "D:\\promotion1.log";
		File file = new File(path);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;


                           int i =0;
			while ((line = br.readLine()) != null) {
                            
				//System.out.println(line);
                                String [] tokens = line.split("-");
                                String valueNeeded = tokens[1];
                                String time1 = tokens[1];
                                String time2 = tokens[2];
                                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                                Date date1 = format.parse(time1);
                                Date date2 = format.parse(time2);
                                long difference = date2.getTime() - date1.getTime();
                                long difference2 = difference/1000;
                                long second = 0;
                                long cost = 0;
                                if(difference2 % 60 != 0){
                                         second = (difference2 / 60 ) +1;
                                
                                }else{
                                        second = (difference2 / 60 ) ;
                                }
  
                                    cost = ((second -1)*1) + 3;
                                    
                                  a.add("Phone : "+ tokens[3]+" Cost :"+ cost + "  Baht"); 
                                   
                                   
                           
                         
                         
                               
                                
                          i++;    
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
              model.put("phone",a);
    
           return "/read.jsp";
        
        } 
        
        
        
   
  
}
