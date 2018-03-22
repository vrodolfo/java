
public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        return (str1.trim() + str2.trim());
    }

    public Integer getIndexOrNull(String str1, char str2) {
    	int idx = str1.indexOf(str2);
    	if(idx == -1){
    		return null;
    	}
    	else{
    		return (idx);
    	} 
    }

    public Integer getIndexOrNull(String str1, String str2) {
        int idx = str1.indexOf(str2);
    	if(idx == -1){
    		return null;
    	}
    	else{
    		return (idx);
    	}
    }

    public String concatSubstring(String str1,int a, int b,  String str2) {

        return (str1.substring(a,b) + str2);
    }
}
