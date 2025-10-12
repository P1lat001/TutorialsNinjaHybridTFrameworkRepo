package summa;

public class Engineer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		        String str[] = {" I am an Engineer"};
//		        int count = 0;
//		        System.out.println(str.length);
//
//		        for (String s : str) 
//		        {
//		        
//		            for (int i = 0; i < s.length(); i++)
//		            {
//		                char ch = s.charAt(i);
//		                if (ch == 'e' || ch == 'E') 
//		                {
//		                    count++;
//		                }
//		            }
//		        }
//
//		        System.out.println("Total number of 'e' and 'E': " + count);
//		        
		        
		 String str = " E ";
         int count = 0;
         String strl = str.toLowerCase();
         System.out.println(str.length());
		 
		 for (int i = 0; i < strl.length(); i++) 
		 {
			 
			char ch=strl.charAt(i);
			String chstr = String.valueOf(ch);
			
			 if (chstr.equalsIgnoreCase("e")  ) 
			 {
				 count++;
			 }
		 }
		 System.out.println("Total number of 'e': " + count);
		}
		        
		    }
		
	
