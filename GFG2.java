// { Driver Code Starts
    import java.util.Scanner;
    import java.io.*;
    class Node{
        int coeff;
        int pow;
        Node next;
        Node(int a,int b)
        {
            coeff=a;
            pow=b;
            next=null;
        }
    }
    class GFG2
    {
        public static void main(String args[])
        {
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0)
            {
                int n=sc.nextInt();
                Node start1=null,cur1=null,start2=null,cur2=null;
                while(n-->0)
                {
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    Node ptr=new Node(a,b);
                    if(start1==null)
                    {
                        start1=ptr;
                        cur1=ptr;
                    }
                    else{
                        cur1.next=ptr;
                        cur1=ptr;
                    }
                }
                n=sc.nextInt();
                while(n-->0)
                {
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    Node ptr=new Node(a,b);
                    if(start2==null)
                    {
                        start2=ptr;
                        cur2=ptr;
                    }
                    else{
                        cur2.next=ptr;
                        cur2=ptr;
                    }
                }
                Solution obj=new Solution();
                Node sum = obj.addPolynomial(start1,start2);
                for(Node ptr=sum ; ptr != null; ptr=ptr.next  )
                {
                    // printing polynomial
                    System.out.print(ptr.coeff + "x^" + ptr.pow);
                    if(ptr.next != null)
                    System.out.print(" + ");
                }
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    /*class Node{
        int coeff;
        int pow;
        Node next;
        Node(int a,int b)
        {
            coeff=a;
            pow=b;
            next=null;
        }
    }*/
    
    //Print the polynomial formed by adding both LL in the function itself.
    class Solution
    {
        static void print(Node p1){
            Node p=p1;
            while(p!=null){
                System.out.print(p.coeff+" "+p.pow);
                p=p.next;
            }
            System.out.println();
        }
        public static Node addPolynomial(Node p1,Node p2)
        {
            Node ans=new Node(1,1);
            Node curr=ans;
            while(p1!=null||p2!=null){
                if(p1!=null&&p2!=null){
                    if(p1.pow<p2.pow){
                        ans.next=p1;
                        p2=p2.next;
                    }
                    else if(p1.pow>p2.pow){
                        ans.next=p2;
                        p1=p1.next;
                    }
                    else{//equal
                        ans.next=new Node(p1.coeff+p2.coeff,p1.pow);
                    }
                
                }
                else{
                    if(p1==null) {
                        ans.next=p2;
                        p2=p2.next;
                    }
                    else{ 
                        ans.next=p1;
                        p1=p1.next;
                    }
                }
                ans=ans.next;
                print(ans);
            }
            return curr;
        }
    }