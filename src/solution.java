//import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.xml.transform.Templates;

public class solution {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		solution solution=new solution();
		//List<String> object=solution.generatePossibleNextMoves("++++");
		//solution.reverseInteger(123);
		char[] alphabet={'c','b','a','d','e','f','g','h'};
		String[] words= {"cab","cba","abc"};
		solution.wordSort(alphabet, words);
		}
	
	
	
	public String[] wordSort(char[] alphabet, String[] words) {
        // Write your code here
		Map<Character, Integer> map=new HashMap<>();
		for(int i=0;i<alphabet.length;i++) {
			map.put(alphabet[i], i);
		}
		Comparator<String> comparator=new Comparator<String>() {
			@Override
			public int compare(String w1, String w2) {
				// TODO Auto-generated method stub
				int len=Math.min(w1.length(), w1.length());
				for(int i=0;i<len;i++){
					if(map.get(w1)>map.get(w2)) {
						return 1;
					}
					else if(map.get(w1)<map.get(w2))
						return -1;
				}
				return w1.length()==w2.length()?0:w1.length()-w2.length();
				//return 0;
			}
		};
		
		Arrays.sort(words,comparator);
		return words;
    }
	public int reverseInteger(int n) {
        // write your code here
		String ccString=String.valueOf(n);
		Stack<Integer> left=new Stack<Integer>();
		left.push(n%10);
		//int a=n%10;
		int b=n/10;
		int count=1;
		while(b!=0) {
			left.push(b%10);
			b=b/10;
			count++;
		}
		int sum=0;
		int standard=Integer.MAX_VALUE%1000000000;
		for(int i=1;i<count;i++) {
			sum+=left.pop()*Math.pow(10, 0);
			if(sum>=standard&&left.peek()>=2) {
				return 0;
			}
		}
		//if()
		return sum;
    }
	
	
	 public List<String> nameDeduplication(String[] names) {
	        // write your code here
		 List<String> anStrings=new ArrayList<String>();
		 for (String string : names) {
			string=string.toLowerCase();
			if(!anStrings.contains(string))
				anStrings.add(string);
		}
		 return anStrings;
	  }
	
	 public class TreeNode {
		      public int val;
		      public TreeNode left, right;
		      public TreeNode(int val) {
		          this.val = val;
		          this.left = this.right = null;
		      }
		  }
	 
	 public int longestConsecutive(TreeNode root) {
	        // write your code here
		 return helper(root, null, 0);
	    }
	public int  helper(TreeNode root,TreeNode parent ,int length) {
		if(root==null) {
			return 0;
		}
		if(parent!=null&&parent.val+1==root.val) {
			length+=1;
		}
		else
			length=1;
		int left=helper(root.left, root, length);
		int right=helper(root.right, root, length);
		return Math.max(length, Math.max(left, right));
	}
	 public class Interval {
		      int start, end;
		      Interval(int start, int end) {
		          this.start = start;
		          this.end = end;
		      }
		  }
	 
//	 public List<Interval> sort(List<Interval> intervals){
//		 
//	 }
	public List<Interval> merge(List<Interval> intervals) {
        // write your code here
		if(intervals.size()<=1) {
			return intervals;
		}
		Deque<Interval> aQueue=new LinkedList<Interval>();
		List<Interval> ans=new ArrayList<Interval>();
		aQueue.offerLast(intervals.get(0));
		for(int i=1;i<intervals.size();) {

			Interval temp=aQueue.pollLast();

			int max=Math.max(temp.end, intervals.get(i).end);
			
		}
		
		return ans;
    }
	public boolean isValidParentheses(String s) {
        // write your code here
		Stack<Character> stack=new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if("({[".contains(String.valueOf(c))) {
				stack.push(c);
			}
			else if(!stack.isEmpty()) {
				if(stack.peek()=='('&&c==')') {
					stack.pop();
				}
				else if(stack.peek()=='{'&&c=='}') {
					stack.pop();
				}
				else if(stack.peek()=='['&&c==']') {
					stack.pop();
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		return stack.isEmpty();
    }
	 public int numWays(int n, int k) {
	        // write your code here
		 if(n==1) {
			 return k;
		 }
		 if(n==2) {
			 return k*k;
		 }
		 if(k==1&&n>2) {
			 return 0;
		 }
		 int num=0;
		 num+=k*Math.pow(k-1, n-2);
		 num=num*(n-1);
		 num+=k*Math.pow(k-1, n-1);
		 return num;
	    }
	public String addStrings(String num1, String num2) {
	       // write your code here
		String anString="";
		int a=num1.length()-1,b=num2.length()-1,flag=0;
		while(a>=0|b>=0) {
			int i=0,j=0;
			if(a>=0)
				i=num1.charAt(a)-'0';
			else 
				i=0;
			if(b>=0)
				j=num2.charAt(b)-'0';
			else
				j=0;
			int sum=i+j+flag;
			anString=(char)(sum%10+'0')+anString;
			flag=sum/10;
		}
		return flag==1? "1"+anString:anString;
	   }
	
	public boolean validWordSquare(String[] words) {
        // Write your code here
		List<String> list=new ArrayList<String>();
		for(int i=0;i<words.length;i++) {
			StringBuilder sBuilder=new StringBuilder();
			for (String string : words) {
				//String temp="";
				if(i<string.length()) {
					sBuilder.append(string.charAt(i));
				}				
			}
			String temp=sBuilder.toString();
			if(!temp.equals(words[i]))
				return false;
		}
		
		
		return true;
		}
	 public List<String> generatePossibleNextMoves(String s) {
	        // write your code here
		 
		 List<String> list =new ArrayList<String>();
		// int ;
		 for(int i=0;i<=s.length()-2;i++) {
			 char[] ch=s.toCharArray();
			 if(s.substring(i, i+2).equals("++")) {
				 ch[i]='-';ch[i+1]='-';
				 String str=String.valueOf(ch);
				 list.add(str);
				 
			 }
		 }
		 return list;
	    }

	public boolean isToeplitzMatrix(int[][] matrix) {
		int rows=matrix.length;//行数
		int cols=matrix[0].length;//列数
		if(rows==1||cols==1)
			return	true;
		int i=0;
		for(int j=0;j<cols-1&&i<rows-1;j++) {
			if(matrix[i][j]==matrix[++i][j+1])
				continue;
			else {
				return false;
			}
		}
		i=0;
		for(int j=0;j<rows-1&&i<cols-1;j++) {
			if(matrix[j][i]==matrix[j+1][++i])
				continue;
			else {
				return false;
			}
		}
		return true;
		
    	// Write your code here
    	}
	
	public String similarRGB(String color) {
		
		String temp=color.substring(0, 2);
		String answer="";
		boolean[] value= {false,false,false};
		for(int i=0;i<3;i++) {
			if(color.charAt(i*2+1)!=color.charAt(i*2+2))
				value[i]=true;
		}
//		int one,two,three;
//		one=Integer.valueOf(temp,16);
//		temp=color.substring(2, 4);
//		two=Integer.valueOf(temp,16);
//		temp=color.substring(4, 6);
//		three=Integer.valueOf(temp, 16);
		
		
		
		return answer;
        // Write your code here
    }
}
