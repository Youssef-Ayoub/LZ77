import java.util.*;


public class MAIN {
    
    private int[] indexes = new int[1000] ;
    private char [] last = new char[1000] ;
    private int l ;

    public void compression() {
        String input = "ABAABABAA" ;
        String temp = "" ;
        Vector<String> v = new Vector<>() ;
        v.add(null) ;
        int index = 0 , sz = 0;
        
        for(int i = 0 ; i < input.length() ; ++i){
            temp += input.charAt(i) ;
            
            if(v.indexOf(temp) == -1){
                indexes[sz] = index ;
                last[sz] = temp.charAt(temp.length() - 1) ;
                sz++ ;
                
                v.add(temp) ;
                temp = "" ;
                index = 0 ;
            }else {
                index = v.indexOf(temp) ;
            }
        }
        if(temp != ""){
            indexes[sz] = index ;
            last[sz] = temp.charAt(temp.length() - 1) ;
            
        }
        
        for(int k = 0 ; k < sz ; ++k){
            System.out.println(indexes[k] + "   " + last[k]);
        }
        l = sz ;
    }
    
    public void decompression(){
        Vector<String> dec = new Vector<>() ;
        String output = "" ;
        String temp = "" ;
        dec.add(null) ;
        
        for(int i = 0 ; i < l ; ++i){
            temp = "" ;
            if(indexes[i] == 0){
                temp += last[i] ;
                dec.add(temp) ;
                output += temp ;
            }else{
                temp = dec.get(indexes[i]) ;
                if(last[i] == 0){
                    output += temp ;
                }else {
                    temp += last[i] ;
                    output += temp ;
                    dec.add(temp) ;
                }
            }
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        MAIN m = new MAIN() ;
        m.compression();
        m.decompression(); 
        
    }
}
